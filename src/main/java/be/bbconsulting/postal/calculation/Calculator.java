package be.bbconsulting.postal.calculation;

import be.bbconsulting.postal.model.CalculationInfo;
import be.bbconsulting.postal.model.CalculationResult;
import be.bbconsulting.postal.model.FirstPart;
import be.bbconsulting.postal.model.PostalInformation;
import be.bbconsulting.postal.model.Round;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public List<Round> calculate(PostalInformation postalInformation) {

        initiateCalculation();

        CalculationInfo calculationInfo = getCalculationInfo();

        FirstPart firstPart = calculateFirstPart(calculationInfo);

        persistFirstPart(firstPart);

        updatePostalInformation(postalInformation);

        CalculationInfo moreCalculationInfo = getMoreCalculationInfo();

        CalculationResult result = calculateResult(moreCalculationInfo);

        return persistResult(result);
    }

    private void initiateCalculation() {};

    private CalculationInfo getCalculationInfo() {
        return new CalculationInfo();
    }

    private FirstPart calculateFirstPart(CalculationInfo calculationInfo) {
        return new FirstPart();
    }

    private void persistFirstPart(FirstPart firstPart) {};

    private void updatePostalInformation(PostalInformation postalInformation){}

    private CalculationInfo getMoreCalculationInfo() {
        return new CalculationInfo();
    }

    private CalculationResult calculateResult(CalculationInfo moreCalculationInfo){
        return new CalculationResult();
    }

    private List<Round> persistResult(CalculationResult result) {
        return new ArrayList<>();
    }
}
