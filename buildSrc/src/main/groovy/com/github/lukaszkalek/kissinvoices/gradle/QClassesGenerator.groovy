package com.github.lukaszkalek.kissinvoices.gradle

import javax.sql.DataSource

import org.apache.commons.dbcp2.BasicDataSource
import org.gradle.api.Plugin
import org.gradle.api.Project

import com.mysema.query.sql.Configuration
import com.mysema.query.sql.H2Templates
import com.mysema.query.sql.codegen.DefaultNamingStrategy
import com.mysema.query.sql.codegen.MetaDataExporter


class QClassesGenerator implements Plugin<Project> {

    def void apply(Project project) {
        project.extensions.create("qClassesGeneratorCfg", QClassesGeneratorExtension)
        project.task('qClassesGenerator') << {
			QClassesGeneratorExtension cfg = project.qClassesGeneratorCfg
            def MetaDataExporter exporter = retrieveConfiguredMetaDataExporter(cfg)
			def DataSource ds = retrieveConfiguredDataSource(cfg)
			exporter.export(ds.getConnection().getMetaData())
        }
    }

	private MetaDataExporter retrieveConfiguredMetaDataExporter(QClassesGeneratorExtension cfg) {
		
		String targetPackage = cfg.targetPackage ?: "com.github.lukaszkalek.kissinvoices.db.domain"
		def File targetFolder = cfg.targetFolder
		targetFolder.mkdirs()

		def MetaDataExporter exporter = new MetaDataExporter()
		exporter.setPackageName(targetPackage)
		exporter.setTargetFolder(targetFolder)
		exporter.setNamingStrategy(new DefaultNamingStrategy())
		exporter.setExportForeignKeys(false)
		exporter.setConfiguration(new Configuration(new H2Templates())) // move this to factory
		exporter
	}
	
	private DataSource retrieveConfiguredDataSource(QClassesGeneratorExtension cfg) {
		BasicDataSource ds = new BasicDataSource()
		ds.setDriverClassName(cfg.driverClassName)
		ds.setUrl(cfg.url)
		ds.setUsername(cfg.user)
		ds.setPassword(cfg.password)
		ds
	}
}

class QClassesGeneratorExtension {
    String driverClassName
    String url
    String user
    String password
	String targetPackage
    File targetFolder
}
