public class Movie {
    private String title;
    private String year;
    
    public Movie() {
        this.title = "UNKNOWN";
        this.year = "N/A";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return this.title;
    }

    public String getYear() {
        return this.year;
    }

    public String findYear(String[] arrOfStr) {
        for (String item : arrOfStr) {
            if (item.length() == 4) {
                try {
                    Integer.parseInt(item);
                    return item;
                } catch (NumberFormatException e) {
                    //pass
                }
            }


        }
        return "N/A";
    }



}
