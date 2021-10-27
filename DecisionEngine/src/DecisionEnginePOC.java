import java.util.List;
import java.util.Map;

public class DecisionEnginePOC {

    private Map<Object, Object> dataMemory;
    private Map<Object, List<BaseHandler>> ltm;
    private Map<Object, List<BaseHandler>> exclusion;
    private List<BaseHandler> handlers;

    public Values decisionEngine(Object input) {
        Object handled = objectHandler(input);
        if (handled == input)
            return Values.FAILED;
        BaseHandler handler = memory(handled);
        return handler.handler(handled);
    }

    private Object objectHandler(Object input) {
        Object converted = dataMemory.get(input);
        if (converted.equals(input)) {
            converted = unknownObjectHandler(input);
        }
        return converted;
    }

    private Object unknownObjectHandler(Object input) {
        Object returned = input;
        for (BaseHandler handler : handlers) {
            Object converted = handler.conversion(input);
            if (!converted.equals(input)) {
                returned = converted;
                List<BaseHandler> handlerList = ltm.get(returned);
                handlerList.add(handler);
                ltm.put(returned, handlerList);
            }
        }
        return returned;
    }

    private BaseHandler memory(Object input) {
        List<BaseHandler> handlerList = ltm.get(input);
        if (handlerList.size() > 1) {
            for (BaseHandler handler : handlerList) {
                if (handler == exclusion.get(input)) {
                    handlerList.remove(handler);
                    ltm.put(input, handlerList);
                }
            }
        }
        return handlerList.get(0);
    }

}
