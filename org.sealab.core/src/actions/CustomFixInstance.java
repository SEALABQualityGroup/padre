package actions;
import org.eclipse.epsilon.evl.dom.Fix;
import org.eclipse.epsilon.evl.execute.FixInstance;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;

public class CustomFixInstance extends FixInstance {

	public CustomFixInstance(IEvlContext context, Fix fix) {
		super(context, fix);
	}
	
	public void setContext(IEvlContext context) {
		this.context = context;
	}
}
