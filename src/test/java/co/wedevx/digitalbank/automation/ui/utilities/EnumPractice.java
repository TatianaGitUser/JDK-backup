package co.wedevx.digitalbank.automation.ui.utilities;

import okhttp3.MediaType;

public enum EnumPractice {
    CSV("text/csv");

    private final String contentType;

    EnumPractice(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public static void main(String[] args) {
        String s = EnumPractice.CSV.getContentType();
        // Returns the value of CSV
        System.out.println(s);

        EnumPractice mediaType = EnumPractice.CSV;
        // Prints CSV
        System.out.println(mediaType);
    }
}
