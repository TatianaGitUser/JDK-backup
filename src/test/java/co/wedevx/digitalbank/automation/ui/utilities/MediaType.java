package co.wedevx.digitalbank.automation.ui.utilities;

public enum MediaType {
        JSON("application/json"),
        CSV("text/csv"),
        XML("application/xml"),
        ANY("*/*");

        private final String type;

        //constructor
        MediaType(String s){
            type = s;
        }

        public String getContentType(){
            return type;
        }
    }

