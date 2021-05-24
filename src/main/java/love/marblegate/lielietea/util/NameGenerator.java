package love.marblegate.lielietea.util;

import love.marblegate.lielietea.datastructure.enumeration.UniversalPlantType;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class NameGenerator {
    public static String generateRandName(UniversalPlantType universalPlantType, int randomSeed){
        switch (universalPlantType){
            case GREENHOUSE_C:
                return nameC(randomSeed);
            case GREENHOUSE_B:
                return nameB(randomSeed);
            default:
                return "NA";
        }
    }

    public static String nameC(int randomSeed){
        Random rand = new Random(randomSeed);
        StringBuffer buff = new StringBuffer();

        //Generate Name Part
        //Max Combining Parts for Name is 12. Min is 6
        int nameCombiningLength = rand.nextInt(13)+6;
        buff.append(generateNameCombiningPart(nameCombiningLength,rand)).append(" ");

        //Generate Code Part
        //Max Length is 16. Min Length is 3
        //Max Knot "-" is 4;
        int codeLength = rand.nextInt(14)+3;
        int knot = rand.nextInt(4);
        knot = codeLength<knot+1?codeLength-1:knot;
        buff.append(generateCodePart(codeLength,knot,rand));

        //Generate SuffixPart
        //Available Suf: mild, lim, opt
        if(randomSeed%10<3){
            switch (randomSeed%10){
                case 0:
                    buff.append(" mild");
                    break;
                case 1:
                    buff.append(" lim");
                    break;
                case 2:
                    buff.append(" opt");
                    break;
                default:
            }
        }

        return buff.toString();
    }

    public static String nameB(int randomSeed){
        Random rand = new Random(randomSeed);
        StringBuffer buff = new StringBuffer();

        //Generate Name Part
        //Max Combining Parts for Name is 10. Min is 4
        int nameCombiningLength = rand.nextInt(7)+4;
        buff.append(generateNameCombiningPart(nameCombiningLength,rand));

        return buff.toString();
    }

    public static String generateNameCombiningPart(int nameCombiningLength,Random rand){
        StringBuffer buff = new StringBuffer();
        boolean repeat = false;
        final String[] a = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
        final String[] b = {"e", "u", "i", "o", "a"};
        final int aSize = a.length;
        final int bSize = b.length;
        boolean onA = rand.nextBoolean();
        int i=0;
        if(onA){
            buff.append(a[rand.nextInt(aSize)].toUpperCase());
            if(shouldRepeat(rand)){
                repeat = true;
            }
            else{
                onA = false;
                i++;
            }
        } else {
            buff.append(b[rand.nextInt(bSize)].toUpperCase());
            if(shouldRepeat(rand)){
                repeat = true;
            }
            else{
                onA = true;
                i++;
            }
        }
        while(i<nameCombiningLength){
            if(onA){
                buff.append(a[rand.nextInt(aSize)]);
                if(repeat){
                    repeat = false;
                    onA = false;
                    i++;
                } else {
                    if(shouldRepeat(rand)){
                        repeat = true;
                    } else {
                        onA = false;
                        i++;
                    }
                }
            } else {
                buff.append(b[rand.nextInt(bSize)]);
                if(repeat){
                    repeat = false;
                    onA = true;
                    i++;
                } else {
                    if(shouldRepeat(rand)){
                        repeat = true;
                    } else {
                        onA = true;
                        i++;
                    }
                }
            }
        }

        return buff.toString();
    }

    public static boolean shouldRepeat(Random rand){
        if(rand.nextFloat()<0.1) return true;
        else return false;
    }

    public static String generateCodePart(int codeLength,int knot,Random rand){
        StringBuffer buff = new StringBuffer();
        int usedLength = 0;
        for(int i=0; i<knot; i++){
            int partLength = rand.nextInt(codeLength-(knot-i)-usedLength)+1;
            buff.append(RandomStringUtils.randomAlphanumeric(partLength).toUpperCase());
            if(i!=knot-1){
                buff.append("-");
            }
        }
        return buff.toString();

    }
}
