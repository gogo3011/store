package uni.store.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class MathUtils {
    private MathUtils(){}

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static int getRandomInt(int max){
        return ThreadLocalRandom.current().nextInt(0, max);
    }
}
