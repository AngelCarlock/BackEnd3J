package Mediator;

public class ModuleMessage {
    private String source;
    private String target;
    private String messageType;
    private Object payload;


    // Constructor de la clase ModuleMessage
    public ModuleMessage(String source, String target, String messageType,
                         Object payload) {
        this.source = source;
        this.target = target;
        this.messageType = messageType;
        this.payload = payload;
    }

    // Métodos getter y setter para la variable source
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
