package org.cruxframework.crossdeviceshowcase.client.controller.samples.cruxlabel;

import org.cruxframework.crossdeviceshowcase.client.util.StyleHelper;
import org.cruxframework.crossdeviceshowcase.client.util.messages.DescriptionMessages;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.smartfaces.client.label.Label;

import com.google.gwt.user.client.ui.HTML;

@Controller("cruxLabelController")
public class CruxLabelController
{
	@Inject
	private MyWidgets myWidgets;
	
	@Inject
	private DescriptionMessages componentDescription;
	
	@Expose
	public void onLoad()
	{
		 /* Insert the component description*/
		myWidgets.componentDescription().setHTML(componentDescription.labelDescription());
	}
	
	@BindView("cruxLabel")
	public interface MyWidgets extends WidgetAccessor
	{
		Label cruxLbl();
		HTML componentDescription();
	}

	private void handleStates(String state)
	{
		StyleHelper.getInstance().changeWidgetState(myWidgets.cruxLbl(), state);
	}

	@Expose
	public void setStateDefault()
	{	
		handleStates("default");
	}

	@Expose
	public void setStateSuccess()
	{
		handleStates("success");
	}

	@Expose
	public void setStateWarning()
	{
		handleStates("warn");
	}

	@Expose
	public void setStateError()
	{
		handleStates("error");
	}
	
	public void setMyWidgets(MyWidgets myWidgets) 
	{
		this.myWidgets = myWidgets;
	}

	public void setComponentDescription(DescriptionMessages componentDescription) {
		this.componentDescription = componentDescription;
	}

}
