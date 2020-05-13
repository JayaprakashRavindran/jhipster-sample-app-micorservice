package com.jp.jhipster.microservice;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.jp.jhipster.microservice");

        noClasses()
            .that()
            .resideInAnyPackage("com.jp.jhipster.microservice.service..")
            .or()
            .resideInAnyPackage("com.jp.jhipster.microservice.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.jp.jhipster.microservice.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
