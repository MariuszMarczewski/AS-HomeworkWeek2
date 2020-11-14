package pl.mmarczewski.ashomeworkweek2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Info{

    public Info() {
    }

    @Value("${info-VAT}")
    private String vat;

    @Value("${info-discount}")
    private String discount;

    @Value("${info-message}")
    private String message;

    public String getVat() {
        return vat;
    }

    public String getDiscount() {
        return discount;
    }

    public String getMessage() {
        return message;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        System.out.println("Welcome again!" );
    }
}
