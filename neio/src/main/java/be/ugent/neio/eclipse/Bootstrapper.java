package be.ugent.neio.eclipse;

import org.aikodi.chameleon.analysis.dependency.DependencyOptionsFactory;
import org.aikodi.chameleon.core.language.Language;
import org.aikodi.chameleon.eclipse.connector.EclipseBootstrapper;
import org.aikodi.chameleon.eclipse.connector.EclipseEditorExtension;
import org.aikodi.chameleon.workspace.ProjectException;

import be.kuleuven.cs.distrinet.jnome.analysis.dependency.JavaDependencyOptionsFactory;
import be.kuleuven.cs.distrinet.jnome.eclipse.JavaEditorExtension;
import be.ugent.neio.industry.NeioLanguageFactory;
import be.ugent.neio.language.Neio;

public class Bootstrapper extends EclipseBootstrapper {

	public Language createLanguage() throws ProjectException {
		Neio result = new NeioLanguageFactory().create();
		result.setPlugin(EclipseEditorExtension.class, new JavaEditorExtension());
		result.setPlugin(DependencyOptionsFactory.class, new JavaDependencyOptionsFactory());
		return result;
	}

}
