package uk.co.xenonique.digital.instant.control;

import javax.faces.component.*;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * The type WorkerBannerComponent
 *
 * @author Peter Pilgrim
 */
@FacesComponent("workerBannerComponent")
public class WorkerBannerComponent extends UINamingContainer {
    private String gettingStartedActive;
    private String yourDetailsActive;
    private String yourRateActive;
    private String yourAddressActive;
    private String confirmActive;
    private String completedActive;

    @Override
    public void encodeAll(FacesContext context) throws IOException {
        if (context == null) {
            throw new NullPointerException("no faces context supplied");
        }
        String sectionName = (String)getAttributes().get("sectionName");
        gettingStartedActive = yourDetailsActive =
            yourRateActive = yourAddressActive =
                confirmActive = completedActive = "";

        if ( "gettingStarted".equalsIgnoreCase(sectionName)) {
            gettingStartedActive = "active";
        }
        else if ( "yourDetails".equalsIgnoreCase(sectionName)) {
            yourDetailsActive = "active";
        }
        else if ( "yourRate".equalsIgnoreCase(sectionName)) {
            yourRateActive = "active";
        }
        else if ( "yourAddress".equalsIgnoreCase(sectionName)) {
            yourAddressActive = "active";
        }
        else if ( "confirm".equalsIgnoreCase(sectionName)) {
            confirmActive = "active";
        }
        else if ( "completed".equalsIgnoreCase(sectionName)) {
            completedActive = "active";
        }
        super.encodeAll(context);
    }

    // Getters and setters omitted

    public String getGettingStartedActive() {
        return gettingStartedActive;
    }

    public void setGettingStartedActive(String gettingStartedActive) {
        this.gettingStartedActive = gettingStartedActive;
    }

    public String getYourDetailsActive() {
        return yourDetailsActive;
    }

    public void setYourDetailsActive(String yourDetailsActive) {
        this.yourDetailsActive = yourDetailsActive;
    }

    public String getYourRateActive() {
        return yourRateActive;
    }

    public void setYourRateActive(String yourRateActive) {
        this.yourRateActive = yourRateActive;
    }

    public String getYourAddressActive() {
        return yourAddressActive;
    }

    public void setYourAddressActive(String yourAddressActive) {
        this.yourAddressActive = yourAddressActive;
    }

    public String getConfirmActive() {
        return confirmActive;
    }

    public void setConfirmActive(String confirmActive) {
        this.confirmActive = confirmActive;
    }

    public String getCompletedActive() {
        return completedActive;
    }

    public void setCompletedActive(String completedActive) {
        this.completedActive = completedActive;
    }
}