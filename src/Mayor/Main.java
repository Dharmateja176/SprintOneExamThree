package Mayor;
//ignore package
//start from here

import java.text.DecimalFormat;
import java.util.Scanner;

class VISACard {
    private String holderName;
    private String ccv;

    public VISACard(String holderName, String ccv) {
        this.holderName = holderName;
        this.ccv = ccv;
    }

    public Double computeRewardPoints(String purchaseType, Double amount) {
        double rewardPoints;
        double rate = 0.01;
        rewardPoints = amount * rate;
        return rewardPoints;
    }
}

class HPVISACard extends VISACard {
    public HPVISACard(String holderName, String ccv) {

        super(holderName, ccv);
    }

    @Override
    public Double computeRewardPoints(String purchaseType, Double amount) {
        double rewardPoints = super.computeRewardPoints(purchaseType, amount);
        if (purchaseType.equals("fuel"))
            return rewardPoints + 10.0;
        return rewardPoints;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat sdf = new DecimalFormat("0.0");
        String holderName = sc.nextLine();
        String ccv = sc.nextLine();
        double amount = sc.nextDouble();
        sc.nextLine();
        String type = sc.nextLine();
        int option = sc.nextInt();
        if (option == 1)
            System.out.println(sdf.format(new VISACard(holderName, ccv).computeRewardPoints(type, amount)));
        else if (option == 2)
            System.out.println(sdf.format(new HPVISACard(holderName, ccv).computeRewardPoints(type, amount)));
        else
            System.out.println("Invalid Choice");
    }
}

