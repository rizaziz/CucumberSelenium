package testdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 10/1/16.
 */
public class TestDataGeneratorImplementation {

    private static final String[] states={"Alabama", "Alaska", "Arizona", "Arkansas", "California",
            "Colorado","Connecticut","Delaware","Florida","Georgia", "Hawaii", "Idaho","Illinois",
            "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
            "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
            "New Jersey", "New Mexico", "New York", "North Coralina", "North Dakota", "Ohio", "Oklahoma", "Oregon",
            "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah","Vermont",
            "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming", "Washington DC", "Puerto Rico",
            "American Samoa", "Guam", "N. Mariana Islands", "US Virgin Islands"
    };
    private static final String[] types={"Annually", "Pay Per Period"};
    private static final String[] frequencys={"Daily", "Weekly", "Bi-weekly", "Semi-monthly", "Monthly","Quarterly", "Semi-annually", "Annually"};
    private static final String[] statuses={"Single", "Married", "Married Use Single Rate", "Nonresident Alien"};

    public static List<TestDataModel> generate(int size){

        List<TestDataModel> testData=new ArrayList<>();
        Random random=new Random();
        TestDataModel entity=null;

        for(int j=0; j<size; j++){

            entity=new TestDataModel();

            entity.setDate(new java.sql.Date(System.currentTimeMillis()+random.nextInt()*10L));
            entity.setGross((double)random.nextInt(300000));
            entity.setState(states[random.nextInt(1000)%states.length]);
            entity.setType(types[random.nextInt(1000)%types.length]);
            entity.setFrequency(frequencys[random.nextInt(1000)%frequencys.length]);
            entity.setStatus(statuses[random.nextInt(1000)%statuses.length]);
            entity.setAllowances(random.nextInt(1000)%5);

            testData.add(entity);


        }

        return testData;
    }

    public static void main(String[] args){
        for(TestDataModel ent:generate(50)){

            System.out.println(ent);

        }


    }
}
