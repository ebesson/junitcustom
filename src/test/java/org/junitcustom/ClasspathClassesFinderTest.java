/**
 *
 * @author ebesson
 */
package org.junitcustom;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junitcustom.data.annotation.MonAnnnotationNonUtilisee;


/**
 * Classe de tests pour la classe utilitaire @link ClasspathClassesFinder.
 *
 * @author ebesson
 */
public class ClasspathClassesFinderTest {

    /**
     * Test la récupération de classes dans un package avec une annotation qui n'est pas utilisée.
     */
    @Test
    public void doitRetournerListeVideSiAucuneAnnotationTrouvee() {

        // Quand j'ai un package qui existe avec une annotation qui n'est pas utilisée
        String packageName = "fr.pagesjaunes.testsautos.socle.technique.categories.data";
        Class<MonAnnnotationNonUtilisee> annotation = MonAnnnotationNonUtilisee.class;

        // Si je scanne mon package avec mon annotation
        int nombreClassesTrouvees = ClasspathClassesFinder.getSuiteClasses(packageName, annotation).length;

        // Alors le nombre de classes trouvées est vide
        Assert.assertEquals("La liste doit être vide", 0, nombreClassesTrouvees);
    }

    /**
     * Test la récupération de classes dans un package avec une annotation.
     */
    @Test
    public void doitRetournerUneSuiteNonVideSiAnnotationTrouvee() {
        // Quand j'ai un package qui existe avec une annotation qui est pas utilisée
        String packageName = "fr.pagesjaunes.testsautos.socle.technique.categories.data";
        Class<Category> annotation = Category.class;

        // Si je scanne mon package avec mon annotation
        int nombreClassesTrouvees = ClasspathClassesFinder.getSuiteClasses(packageName, annotation).length;

        // Alors le nombre de classes trouvées est supérieur ou égale à 1
        Assert.assertTrue("La liste doit au moins contenir 1 classe", nombreClassesTrouvees >= 1);
    }
}