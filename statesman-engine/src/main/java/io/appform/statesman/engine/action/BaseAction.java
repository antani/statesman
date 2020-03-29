package io.appform.statesman.engine.action;


import io.appform.statesman.model.Action;
import io.appform.statesman.model.Workflow;
import io.appform.statesman.model.action.data.ActionData;
import io.appform.statesman.model.action.template.ActionTemplate;

public abstract class BaseAction<T extends ActionData, J extends ActionTemplate> implements Action<J> {

    public abstract void handle(T actionData);

    public abstract T transformPayload(Workflow workflow, J actionTemplate);

    public void queue(T actionData) {
        //TODO: Add to queue
    }

    @Override
    public void apply(J actionTemplate, Workflow workflow) {
        T actionData = transformPayload(workflow, actionTemplate);
        if (actionTemplate.isSync()) {
            handle(actionData);
        } else {
            queue(actionData);
        }
    }

}
