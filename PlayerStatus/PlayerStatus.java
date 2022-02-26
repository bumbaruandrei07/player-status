package PlayerStatus;

import java.util.Objects;

public class PlayerStatus {
    private String nickname;
    private int score;
    private int lives;
    private int health;
    private String weaponInHand;
    private double positionX;
    private double positionY;
    private int probability;
    private static String gameName = "CS:GO";

    public void initPlayer(String nickname) {
        this.nickname = nickname;
    }

    public void initPlayer(String nickname, int lives) {
        this.nickname = nickname;
        this.lives = lives;
    }

    public void initPlayer(String nickname, int lives, int score) {
        this.nickname = nickname;
        this.lives = lives;
        this.score = score;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPerfect(int n) {
        int sum = 0;
        if (n > 0) {
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }
            return sum == n;
        }
        return false;
    }

    public static boolean SumOfDigitsIs3(int n) {
        int ultimaCifra;
        int sum = 0;
        while (n != 0) {
            ultimaCifra = n % 10;
            n /= 10;
            sum += ultimaCifra;
        }
        return sum == 3;
    }

    public static boolean evenNumberAndSumOfDigitsIs3(int num) {
        return (num % 2 == 0) && (SumOfDigitsIs3(num));
    }

    public void findArtifact(int artifactCode) {
        if (isPrime(artifactCode)) {
            score += 5000;
            lives += 1;
            health = 100;
        } else if (isPerfect(artifactCode)) {
            score += 1000;
            lives += 2;
            health += 25;
            if (this.health > 100) {
                health = 100;
            }
        } else if (evenNumberAndSumOfDigitsIs3(artifactCode)) {
            score -= 3000;
            health -= 25;
            if (health <= 0) {
                lives--;
                health = 100;
            }
        } else score += artifactCode;
    }


    public boolean setWeaponInHand(String weaponInHand) {
        if (weaponInHand.equals("knife") || weaponInHand.equals("sniper") || weaponInHand.equals("kalashnikov")) {
            if (weaponInHand.equals("knife") && this.score >= 1000) {
                this.weaponInHand = "knife";
                this.score -= 1000;
                return true;
            }
            if (weaponInHand.equals("sniper") && this.score >= 10000) {
                this.weaponInHand = "sniper";
                this.score -= 10000;
                return true;
            }
            if (weaponInHand.equals("kalashnikov") && this.score >= 20000) {
                this.weaponInHand = "kalashnikov";
                this.score -= 20000;
                return true;
            }
        }
        return false;
    }

    public String getWeaponInHand() {
        return weaponInHand;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public static String getGameName() {
        return gameName;
    }

    public static void setGameName(String gameName) {
        PlayerStatus.gameName = gameName;
    }

    public void movePlayerTo(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    //Transformam field-ul in read-only -> nu avem setter, doar getter pentru citire
    public String getNickname() {
        return nickname;
    }

    public void attackOpponent(PlayerStatus opponent) {
        switch (getWeaponInHand()) {
            case "knife":
                opponent.health -= 25;
            case "sniper":
                opponent.health -= 100;
            case "kalashnikov":
                opponent.health -= 100;
        }
        if (opponent.health <= 0) {
            opponent.lives--;
            opponent.health = 100;
        }
        if (opponent.lives == 0) {
            System.out.println("Game over");
            opponent.health = 0;
        }
    }

    public void displayPlayerStatus() {
        System.out.println("Nickname -  " + nickname + "  Score -  " + score + "  Health -  " + health + "  Lives -  " + lives + "  Weapon -  " + getWeaponInHand() + "  Game -  " + getGameName() +
                " Position X -  " + positionX + " Position Y -  " + positionY);
    }

    private double distance(PlayerStatus opponent) {
        return Math.sqrt(((this.positionX - opponent.positionY) * (this.positionX - opponent.positionY)) + ((this.positionY - opponent.positionY) * (this.positionY - opponent.positionY)));
    }

    public boolean shouldAttackOpponent(PlayerStatus opponent) {

        if (this.weaponInHand.equals(opponent.getWeaponInHand())) {
            probability = (3 * health + score / 1000) / 4;
            if (this.probability > opponent.probability) {
                System.out.println(this.nickname + " wins");
                return true;
            }
            if (probability < opponent.probability) {
                System.out.println(opponent.nickname + " wins");
                return false;
            }

        } else {
            if (distance(opponent) > 1000) {
                if ((Objects.equals(this.weaponInHand, "sniper") && (Objects.equals(opponent.weaponInHand, "knife")))) {
                    System.out.println(this.nickname + " wins");
                    return true;
                }
                if ((Objects.equals(opponent.weaponInHand, "sniper") && (Objects.equals(this.weaponInHand, "knife")))) {
                    System.out.println(opponent.nickname + " wins");
                    return false;
                }
                if ((Objects.equals(this.weaponInHand, "kalashnikov") && (Objects.equals(opponent.weaponInHand, "knife")))) {
                    System.out.println(this.nickname + " wins");
                    return true;
                }
                if ((Objects.equals(opponent.weaponInHand, "knife") && (Objects.equals(this.weaponInHand, "kalashnikov")))) {
                    System.out.println(opponent.nickname + " wins");
                    return false;
                }
                if ((Objects.equals(this.weaponInHand, "sniper") && (Objects.equals(opponent.weaponInHand, "kalashnikov")))) {
                    System.out.println(this.nickname + " wins");
                    return true;
                }
                if ((Objects.equals(opponent.weaponInHand, "kalashnikov") && (Objects.equals(this.weaponInHand, "sniper")))) {
                    System.out.println(opponent.nickname + " wins");
                    return false;
                }
            }

            if (distance(opponent) < 1000) {
                if ((Objects.equals(this.weaponInHand, "kalashnikov") && (Objects.equals(opponent.weaponInHand, "knife")))) {
                    System.out.println(this.nickname + " wins");
                    return true;
                }
                if ((Objects.equals(opponent.weaponInHand, "knife") && (Objects.equals(this.weaponInHand, "kalashnikov")))) {
                    System.out.println(opponent.nickname + " wins");
                    return false;
                }
                if ((Objects.equals(this.weaponInHand, "sniper") && (Objects.equals(opponent.weaponInHand, "knife")))) {
                    System.out.println(this.nickname + " wins");
                    return true;
                }
                if ((Objects.equals(opponent.weaponInHand, "knife") && (Objects.equals(this.weaponInHand, "sniper")))) {
                    System.out.println(opponent.nickname + " wins");
                    return false;
                }
                if ((Objects.equals(this.weaponInHand, "kalashnikov") && (Objects.equals(opponent.weaponInHand, "sniper")))) {
                    System.out.println(this.nickname + " wins");
                    return true;
                }
                if ((Objects.equals(opponent.weaponInHand, "sniper") && (Objects.equals(this.weaponInHand, "kalashnikov")))) {
                    System.out.println(opponent.nickname + " wins");
                    return false;
                }
            }
        }
        return false;
    }
}

