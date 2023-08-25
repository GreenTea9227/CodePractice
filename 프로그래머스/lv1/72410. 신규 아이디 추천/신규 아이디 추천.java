class Solution {
    public String solution(String new_id) {
      new_id = new_id.toLowerCase().replaceAll("[^a-z0-9\\-\\_\\.]","")
          .replaceAll("\\.{2,}",".")
          .replaceAll("^\\.","")
            .replace("\\.$","");;

       

        if (new_id.isBlank()) {
            new_id ="a";
        }
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0,15);
        }

        new_id = new_id.replaceAll("\\.$","");

        while (new_id.length()<3) {
            new_id += new_id.charAt(new_id.length()-1);
        }
        
        return new_id;
    }
}