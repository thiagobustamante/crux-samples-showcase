package org.cruxframework.crossdeviceshowcase.client.controller.samples.cruxbutton;

import org.cruxframework.crossdeviceshowcase.client.util.StyleHelper;
import org.cruxframework.crux.core.client.controller.Controller;
import org.cruxframework.crux.core.client.controller.Expose;
import org.cruxframework.crux.core.client.ioc.Inject;
import org.cruxframework.crux.core.client.screen.views.BindView;
import org.cruxframework.crux.core.client.screen.views.WidgetAccessor;
import org.cruxframework.crux.widgets.client.button.Button;

import com.google.gwt.user.client.ui.HTML;

@Controller("cruxButtonController")
public class CruxButtonController
{

	@Inject
	private MyWidgets myWidgets;
	
	@Inject
	private CruxButtonMessages messages;
	
	@Expose
	public void onLoad()
	{
		 /* Insert the component description*/
		myWidgets.htmlDescText().setHTML(messages.htmlDescText());
	}
	
	@BindView("cruxButton")
	public interface MyWidgets extends WidgetAccessor
	{
		Button cruxBtn();
		HTML htmlDescText();
	}

	private void handleStates(String state)
	{
		StyleHelper.getInstance().changeWidgetState(myWidgets.cruxBtn(), state);
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

	public void setMessages(CruxButtonMessages messages) {
		this.messages = messages;
	}

}
