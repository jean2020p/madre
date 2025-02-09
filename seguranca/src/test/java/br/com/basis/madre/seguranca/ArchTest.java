package br.com.basis.madre.seguranca;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("br.com.basis.madre.seguranca");

        noClasses()
            .that()
                .resideInAnyPackage("br.com.basis.madre.seguranca.service..")
            .or()
                .resideInAnyPackage("br.com.basis.madre.seguranca.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..br.com.basis.madre.seguranca.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
