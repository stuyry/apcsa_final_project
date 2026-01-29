package Code;

public interface Attack {
    public interface Scratch {
        double scratchMultipler = 1;
    }

    public interface Jab {
        double jabMultiplier = 0.4;
        int MagicGain = 2;
    }

    public interface HayMaker {
        double HayMakerMultiplier = 2.0;
        int MagicDrain = 2;
    }
}
//     public double getScratchMultiplier() {
//         return Scratch.scratchMultipler;
//     }

//     public double getJabMultiplier() {
//         return Jab.jabMultiplier;
//     }

//     public int getJabMagicGain() {
//         return Jab.MagicGain;
//     }

//     public double getHayMakerMultiplier() {
//         return HayMaker.HayMakerMultiplier;
//     }
//     public int getHayMakerMagicDrain() {
//         return HayMaker.MagicDrain;
//     }
// }
