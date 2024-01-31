public class Farm {

    Cow head = new Cow("1", "Immortal");

    static class Cow {
        String nickname;
        String id;
        Cow parent;
        Cow child;

        Cow(String id, String nickname) {
            this.id = id;
            this.nickname = nickname;
        }
    }

    public void giveBirth(String parentCowId, String childCowId, String childNickName, Farm farm) {
        Cow cow = farm.head;
        while (cow != null){
            if (cow.id.equals(parentCowId)){
                Cow child = new Cow(childCowId, childNickName);
                cow.child = child;
                child.parent = cow;
            }
            cow = cow.child;
        }
    }

    public void endLifeSpan(String cowId, Farm farm) {
        Cow cow = farm.head;
        while (cow != null){
            if (cow.id.equals(cowId)){
                cow.parent.child = cow.child;
                cow.child.parent = cow.parent;
                return;
            }
            cow = cow.child;
        }
    }

    public static String printFarmData(Farm farm) {
        Cow cow = farm.head;
        StringBuilder stringBuilder = new StringBuilder();
        while (cow != null){
            stringBuilder.append("Cow id - ").append(cow.id).append("; ");
            stringBuilder.append("Cow nickname - ").append(cow.nickname).append("; ");
            if (cow.child != null) {
                stringBuilder.append("Child nickname - ").append(cow.child.nickname).append("; ");
            }
            if (cow.parent != null) {
                stringBuilder.append("Parent nickname - ").append(cow.parent.nickname).append("; ");
            }
            stringBuilder.append("\n");
            cow = cow.child;
        }
        return stringBuilder.toString();
    }

}
