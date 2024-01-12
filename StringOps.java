public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {

        // System.out.println(capVowelsLowRest("“Hello World”"));
        // System.out.println(capVowelsLowRest("“One two tHRee world”"));
        // System.out.println(capVowelsLowRest("“vowels are fun”"));
        // System.out.println(capVowelsLowRest("“yellow”"));
        System.out.println(spaceCounter("“Hello World”"));
        System.out.println(spaceCounter("“world”"));
        System.out.println(spaceCounter("“ Intro to coMPUter sCIEncE ”"));
        System.out.println(camelCase("“Hello World”"));
        System.out.println(camelCase("“world”"));
        System.out.println(camelCase("“ Intro to coMPUter sCIEncE ”"));




       




        
    }

    public static String capVowelsLowRest (String string) {
        String newStringLower = lowerCase(string);
        String vowels = "aeiou";
        String capVowelsLowRest = "";

        for (int i = 0; i < newStringLower.length(); i++) {
            char ch = newStringLower.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                capVowelsLowRest += (char) (ch - 32);

            } else {
                capVowelsLowRest += ch;
            }


        }
        return capVowelsLowRest;
    }

    public static String lowerCase(String string) {
        String lowerCaseString = "";
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch >= 'A' && ch <='Z'){
                lowerCaseString += (char) (ch + 32);
            }
            else {
                lowerCaseString += ch;
            }
        }

        return lowerCaseString;
    }
    public static int spaceCounter(String string) {
        int spaceCounter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ')  {
                spaceCounter++;
            }
        }
        return spaceCounter;
    }

    public static String camelCase (String string) {
        int [] spaceIndex = new int [spaceCounter(string)]; 
        int index = 0;
        String newString = "";
        String newStringNoSpaces = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                spaceIndex[index] = i;
                index++;
            }
        }

        if (spaceCounter(string) == 0) {
            newString += lowerCase(string);

        } else if (string.charAt(0) == ' ') {
            newString += lowerCase(string.substring(1, spaceIndex[1]));

            for (int i = spaceIndex[1] ; i < string.length() ; i++) {
                if (string.charAt(i) == ' ' && string.charAt(i + 1) >= 'a' && string.charAt(i + 1) <= 'z') {
                    newString += (char) (string.charAt(i + 1) - 32);
                    i++;

                } else if ((string.charAt(i) >= 'A') && (string.charAt(i) <= 'Z')) {
                    newString += (char) (string.charAt(i) + 32);

                } else {
                    newString += string.charAt(i);
                }    
            }

        } else {
            newString += lowerCase(string.substring(0, spaceIndex[0]));

            for (int i = spaceIndex[0] ; i < string.length() ; i++) {
                if (string.charAt(i) == ' ' && string.charAt(i + 1) >= 'a' && string.charAt(i + 1) <= 'z') {
                    newString += (char) (string.charAt(i + 1) - 32);
                    i++;

                } else if ((string.charAt(i) >= 'A') && (string.charAt(i) <= 'Z')) {
                    newString += (char) (string.charAt(i) + 32);

                } else {
                    newString += string.charAt(i);

                }
            }
        }

        for (int i = 0; i < newString.length(); i++) {
            if (newString.charAt(i) != ' ') {
                newStringNoSpaces += newString.charAt(i);
            }
        }

        return newStringNoSpaces;


    }

    public static int chrCounter (String string, char chr) {
        chrCounter = 0;
        for(int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                chrCounter++;
            }
        }
        return chrCounter;


    }

    

    public static int[] allIndexOf (String string, char chr) {
        int [] array = new int [chrCounter(string)];
        int index = 0;

        for(int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                array[index] = i;
                index++;
            }

        }
        return array;
    }
}
