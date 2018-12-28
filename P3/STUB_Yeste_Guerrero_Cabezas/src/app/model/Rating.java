package app.model;

public class Rating {

    private enum Emotion {
        GOOD("Good"), FUNNY("Funny"), WOW("Wow"), SAD("Sad"), MEH("Meh"), BAD("Bad"), ERROR("Error");
        private String emot;
        Emotion(String e) {
            this.emot = e;
        }
        public String toString(){
            return emot;
        }
    }
    private String device;
    private Emotion emotion;
    private SCharacter fCharacter;
    private User user;

    /**
     * Constructor of Rating.
     *
     * @param point         points
     * @param device        device
     * @param fCharacter    favourite character
     * @param user          user who has made the rating
     */
    public Rating(int point, String device, SCharacter fCharacter, User user){
        switch (point){
            case 1:
                this.emotion = Emotion.BAD;
                break;
            case 2:
                this.emotion = Emotion.MEH;
                break;
            case 3:
                this.emotion = Emotion.SAD;
                break;
            case 4:
                this.emotion = Emotion.GOOD;
                break;
            case 5:
                this.emotion = Emotion.FUNNY;
                break;
            case 6:
                this.emotion = Emotion.WOW;
                break;
            default:
                this.emotion = Emotion.ERROR;
                break;
        }
        this.device = device;
        this.fCharacter = fCharacter;
        this.user = user;
    }

    /**
     * Getter for rating's emotion.
     *
     * @return emotion
     */
    public String getEmotion(){
        return this.emotion.toString();
    }

    /**
     * Setter for Rating's emotion.
     *
     * @param e emotion
     */
    public void setEmotion(Emotion e){
        this.emotion = e;
    }

    /**
     * Getter for rating's device.
     *
     * @return device
     */
    public String getDevice(){
        return this.device;
    }

    /**
     * Setter for Rating's device.
     *
     * @param d     device has been rated on
     */
    public void setDevice(String d){
        this.device = d;
    }

    /**
     * Getter for rating's favourite character.
     *
     * @return favourite character
     */
    public SCharacter getfCharacter(){
        return this.fCharacter;
    }

    /**
     * Setter for Rating's favourite character.
     *
     * @param s character
     */
    public void setfCharacter(SCharacter s){
        this.fCharacter = s;
    }

    /**
     * Getter for rating's user.
     *
     * @return emotion
     */
    public User getUser(){ return this.user; }
}

