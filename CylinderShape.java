package final;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Locale;
import javax.media.j3d.Material;
import javax.media.j3d.PhysicalBody;
import javax.media.j3d.PhysicalEnvironment;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Texture;
import javax.media.j3d.Texture2D;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.View;
import javax.media.j3d.ViewPlatform;
import javax.media.j3d.VirtualUniverse;
import javax.swing.JFrame;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.mouse.MouseTranslate;
import com.sun.j3d.utils.behaviors.mouse.MouseZoom;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;


@SuppressWarnings({ "unused", "serial" })
public class CylinderShape extends JFrame implements ActionListener {
	
	private Box box;
	private Shape3D frontShape;
	 GraphicsConfiguration config =

			   SimpleUniverse.getPreferredConfiguration();
  protected Canvas3D myCanvas3D = new Canvas3D(config);

  protected Button exitButton = new Button("Exit");

  protected BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0,
      0.0), 100.0);

  /**
   * Build the view branch of the scene graph
   * 
   * @return BranchGroup that is the root of the view branch
   */
  protected BranchGroup buildViewBranch(Canvas3D c) {
    BranchGroup viewBranch = new BranchGroup();
    Transform3D viewXfm = new Transform3D();
    viewXfm.set(new Vector3f(0.0f, 0.0f, 10.0f));
    TransformGroup viewXfmGroup = new TransformGroup(viewXfm);
    ViewPlatform myViewPlatform = new ViewPlatform();
    PhysicalBody myBody = new PhysicalBody();
    PhysicalEnvironment myEnvironment = new PhysicalEnvironment();
    viewXfmGroup.addChild(myViewPlatform);
    viewBranch.addChild(viewXfmGroup);
    View myView = new View();
    myView.addCanvas3D(c);
    myView.attachViewPlatform(myViewPlatform);
    myView.setPhysicalBody(myBody);
    myView.setPhysicalEnvironment(myEnvironment);
    return viewBranch;
  }

  /**
   * Add some lights to the scene graph
   * 
   * @param b
   *            BranchGroup that the lights are added to
   */
  protected void addLights(BranchGroup b) {
    Color3f ambLightColour = new Color3f(0.5f, 0.5f, 0.5f);
    AmbientLight ambLight = new AmbientLight(ambLightColour);
    ambLight.setInfluencingBounds(bounds);
    Color3f dirLightColour = new Color3f(1.0f, 1.0f, 1.0f);
    Vector3f dirLightDir = new Vector3f(-1.0f, -1.0f, -1.0f);
    DirectionalLight dirLight = new DirectionalLight(dirLightColour,
        dirLightDir);
    dirLight.setInfluencingBounds(bounds);
    b.addChild(ambLight);
    b.addChild(dirLight);
  }

  /**
   * Build the content branch for the scene graph
   * 
   * @return BranchGroup that is the root of the content
   */
  protected BranchGroup buildContentBranch() {
   /* Appearance app = new Appearance();
    Color3f ambientColour = new Color3f(1.0f, 0.0f, 0.0f);
    Color3f emissiveColour = new Color3f(0.0f, 0.0f, 0.0f);
    Color3f specularColour = new Color3f(1.0f, 1.0f, 1.0f);
    Color3f diffuseColour = new Color3f(4.0f, 0.0f, 0.0f);
    float shininess = 20.0f;
    app.setMaterial(new Material(ambientColour, emissiveColour,
        diffuseColour, specularColour, shininess));

    Box cube = new Box(2.0f, 2.0f, 2.0f, app);

	  */
	  
	  Appearance ap = getAppearance(new Color3f(Color.blue));
		ap.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
		ap.setCapability(Appearance.ALLOW_TEXGEN_WRITE);
		box = new Box(2f, 2f, 2f, Primitive.GENERATE_TEXTURE_COORDS,
				getAppearance(new Color3f(Color.green)));		 
		box.setCapability(Box.ENABLE_APPEARANCE_MODIFY);
		box.setCapability(Box.GEOMETRY_NOT_SHARED);		
		box.setCapability(Box.ALLOW_LOCAL_TO_VWORLD_READ);
		frontShape = box.getShape(Box.FRONT);
		frontShape.setAppearance(ap);
		
		 
		box.getShape(Box.TOP).setAppearance(getAppearance(Color.cyan));
		box.getShape(Box.BOTTOM).setAppearance(getAppearance(Color.GRAY)); ;
		box.getShape(Box.RIGHT).setAppearance(getAppearance(Color.red));
		box.getShape(Box.LEFT).setAppearance(getAppearance(Color.green)); 
		box.getShape(Box.BACK).setAppearance(getAppearance(new Color3f(Color.yellow))); 
		
    BranchGroup contentBranch = new BranchGroup();
    addLights(contentBranch);
    //Create the transform groups that will be
    //affected by the mouse utiltities
    TransformGroup spinGroup = new TransformGroup();
    TransformGroup zoomGroup = new TransformGroup();
    TransformGroup moveGroup = new TransformGroup();
    //Set the capabilities of the groups so that we can
    //manipulate them
    spinGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    spinGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    zoomGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    zoomGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    moveGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    moveGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
    //Create and use the rotation utility
    MouseRotate mouseSpin = new MouseRotate();
    mouseSpin.setTransformGroup(spinGroup);
    contentBranch.addChild(mouseSpin);
    mouseSpin.setSchedulingBounds(bounds);
    //Create and use the zoom utility
    MouseZoom mouseSize = new MouseZoom();
    mouseSize.setTransformGroup(zoomGroup);
    contentBranch.addChild(mouseSize);
    mouseSize.setSchedulingBounds(bounds);
    //Create and use the translation utility
    MouseTranslate mouseMove = new MouseTranslate();
    mouseMove.setTransformGroup(moveGroup);
    contentBranch.addChild(mouseMove);
    mouseMove.setSchedulingBounds(bounds);
    //Put it all together
   // spinGroup.addChild(box);
    spinGroup.addChild(new Cylinder(2f,4f));
  
    
    //spinGroup.addChild(new Sphere(2.5f));
    moveGroup.addChild(spinGroup);
    zoomGroup.addChild(moveGroup);
    contentBranch.addChild(zoomGroup);
    return contentBranch;

  }

  /**
   * Use the action event of the exit button to end the application.
   */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == exitButton) {
      dispose();
      //System.exit(0);
    }
  }

  public CylinderShape() {
	  this.setVisible(true);
	  
    VirtualUniverse myUniverse = new VirtualUniverse();
    Locale myLocale = new Locale(myUniverse);
    myLocale.addBranchGraph(buildViewBranch(myCanvas3D));
    myLocale.addBranchGraph(buildContentBranch());
    setTitle("Cylinder");
    setBounds(350,80,600, 600);
    setLayout(new BorderLayout());
  //Panel bottom = new Panel();
  //  Button butn=new Button("Close");
   // bottom.add(butn);
    //butn.addActionListener(new ActionListener() {
	//	public void actionPerformed(ActionEvent arg0) {
	//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	//	}
	//});
    add(BorderLayout.CENTER, myCanvas3D);
    //add(BorderLayout.SOUTH, bottom);
    exitButton.addActionListener(this);
    setVisible(true);
  }

 /* public static void main(String[] args) {
	  Cuboid sm = new Cuboid();
    sm.setVisible(true);
    sm.setBounds(300, 100, 600, 500);
  }*/
  public static Appearance getAppearance(Color color) {
		return getAppearance(new Color3f(color));
	}
  public static Appearance getAppearance(Color3f color) {
		Color3f black = new Color3f(0.0f, 0.0f, 0.0f);
		Color3f white = new Color3f(1.0f, 1.0f, 1.0f);
		Appearance ap = new Appearance();
		Texture texture = new Texture2D();
		TextureAttributes texAttr = new TextureAttributes();
		texAttr.setTextureMode(TextureAttributes.MODULATE);
		texture.setBoundaryModeS(Texture.WRAP);
		texture.setBoundaryModeT(Texture.WRAP);
		texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));
		Material mat = new Material(color, black, color, white, 70f);
		ap.setTextureAttributes(texAttr);
		ap.setMaterial(mat);
		ap.setTexture(texture);	 
		ColoringAttributes ca = new ColoringAttributes(color,
				ColoringAttributes.NICEST);
		ap.setColoringAttributes(ca);
		return ap;
	}
}