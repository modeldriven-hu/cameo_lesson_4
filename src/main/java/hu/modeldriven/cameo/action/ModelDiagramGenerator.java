package hu.modeldriven.cameo.action;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.ModelElementsManager;
import com.nomagic.magicdraw.openapi.uml.PresentationElementsManager;
import com.nomagic.magicdraw.openapi.uml.ReadOnlyElementException;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.magicdraw.uml.DiagramTypeConstants;
import com.nomagic.magicdraw.uml.Finder;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;

import java.awt.*;

public class ModelDiagramGenerator {

    private final Project project;

    private final ModelElementsManager manager;

    private final PresentationElementsManager presentationManager;

    public ModelDiagramGenerator() {
        this.project = Application.getInstance().getProject();
        this.manager = ModelElementsManager.getInstance();
        this.presentationManager = PresentationElementsManager.getInstance();
    }

    public void execute(Package parentPackage) {
        SessionManager.getInstance().createSession(project, "Creating diagram and presentation elements");

        try {
            createDiagram(parentPackage);
            SessionManager.getInstance().closeSession(project);
        } catch (Exception e) {
            SessionManager.getInstance().cancelSession(project);
        }
    }

    private void createDiagram(Package parentPackage) throws ReadOnlyElementException {

        var diagram = manager.createDiagram(DiagramTypeConstants.UML_CLASS_DIAGRAM, parentPackage);
        var diagramPresentation = project.getDiagram(diagram);
        diagramPresentation.open();

        var firstClass = Finder.byName().find(parentPackage,
                com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class,
                "First Class");

        var firstClassShape = presentationManager.createShapeElement(firstClass, diagramPresentation);
        presentationManager.reshapeShapeElement(firstClassShape, new Rectangle(200, 200, 300, 400));
    }


}
