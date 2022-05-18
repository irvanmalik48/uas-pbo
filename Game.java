import java.util.Random;
import java.util.Scanner;

import Birds.Blues;
import Birds.Bomb;
import Birds.Chuck;
import Birds.Matilda;
import Birds.Red;
import Obstacles.Glass;
import Obstacles.Stone;
import Obstacles.Wood;
import Pigs.ArmorPig;
import Pigs.BucketPig;
import Pigs.NormalPig;

public class Game {
    private Blues blue = new Blues();
    private Bomb black = new Bomb();
    private Chuck yellow = new Chuck();
    private Matilda white = new Matilda();
    private Red red = new Red();

    private NormalPig pig = new NormalPig();
    private BucketPig bucketpig = new BucketPig();
    private ArmorPig armorpig = new ArmorPig();

    private Glass glass = new Glass();
    private Wood wood = new Wood();
    private Stone stone = new Stone();
    
    private Random rand = new Random();
    private Scanner scan = new Scanner(System.in);

    public Game() {
        this.blue.setAmount(rand.nextInt(4 - 1 + 1) + 1);
        this.black.setAmount(rand.nextInt(4 - 1 + 1) + 1);
        this.yellow.setAmount(rand.nextInt(4 - 1 + 1) + 1);
        this.white.setAmount(rand.nextInt(4 - 1 + 1) + 1);
        this.red.setAmount(rand.nextInt(4 - 1 + 1) + 1);

        this.pig.setAmount(rand.nextInt(5 - 2 + 1) + 2);
        this.bucketpig.setAmount(rand.nextInt(4 - 1 + 1) + 1);
        this.armorpig.setAmount(rand.nextInt(3 - 0 + 1));

        this.glass.setAmount(rand.nextInt(10 - 4 + 1) + 4);
        this.wood.setAmount(rand.nextInt(10 - 3 + 1) + 3);
        this.stone.setAmount(rand.nextInt(10 - 2 + 1) + 2);
    }

    public void start() {
        displayRules();

    }

    public void displayRules() {
        heading("DESKRIPSI BURUNG");
        System.out.println("\n1. Red adalah burung pemarah berwarna merah. Kekuatan supernya adalah menghancurkan kendaraan babi. (Damage: 1)");
        System.out.println("2. Chuck adalah burung yang terbang cepat berwarna kuning. Kekuatan supernya adalah meluncur layaknya kilat langsung menuju pertahanan babi. (Damage: 2)");
        System.out.println("3. The Blues adalah burung pemberani berwarna biru. Kekuatan supernya adalah berubah menjadi tiga. (Damage: 3)");
        System.out.println("4. Bomb adalah burung pemarah berwarna hitam. Kekuatan supernya adalah meledak. (Damage: 4)");
        System.out.println("5. Matilda adalah burung wanita berwarna putih. Kekuatan supernya adalah mengeluarkan projektil telur yang dapat meledak. (Damage: 3)");
        heading("DESKRIPSI BABI");
        System.out.println("\n1. Babi biasa. (HP: 1)");
        System.out.println("2. Babi bertopi. (HP: 2)");
        System.out.println("3. Babi berarmor. (HP: 3)");
        separator();
        System.out.print("Ketik enter untuk memulai game.");
        scan.nextLine();
        game();
    }

    public void game() {
        System.out.println();
        heading("BURUNG");
        System.out.println(red.currentStatus() + yellow.currentStatus() + blue.currentStatus() + black.currentStatus() + white.currentStatus());
        heading("BABI");
        System.out.println(pig.currentStatus() + bucketpig.currentStatus() + armorpig.currentStatus());
        heading("STRUKTUR");
        System.out.println(glass.currentStatus() + wood.currentStatus() + stone.currentStatus());
        separator();
        
        if (red.getAmount() < 1 && yellow.getAmount() < 1 && blue.getAmount() < 1 && black.getAmount() < 1 && white.getAmount() < 1) {
            if (pig.getAmount() > 0 || bucketpig.getAmount() > 0 || armorpig.getAmount() > 0) {
                System.out.println("Anda kalah!");
                return;
            }
        }

        System.out.println("Silahkan pilih burung yang ingin anda lontarkan:\n1. Red\n2. Chuck\n3. The Blues\n4. Bomb\n5. Matilda");
        System.out.print("Pilih: ");

        int pilihan = scan.nextInt();
        System.out.println();

        switch(pilihan) {
            case 1:
                if (red.getAmount() > 0) {
                    if (rand.nextInt(1 - 0 + 1) < 1 || wood.getAmount() > 0) {
                        wood.setHardness(wood.getHardness() - 1);
                        red.power();
                        System.out.println("Ketahanan kayu berkurang.");
                        if (pig.getAmount() > 0) {
                            pig.setAmount(pig.getAmount() - 1);
                            System.out.println("1 babi biasa terbunuh.");
                        }
                    } else {
                        if (glass.getAmount() > 0) {
                            glass.setAmount(glass.getAmount() - 1);
                            red.power();
                            System.out.println("1 kaca dihancurkan.");
                        } else if (stone.getAmount() > 0) {
                            stone.setHardness(stone.getHardness() - 1);
                            red.power();
                            System.out.println("Ketahanan batu berkurang.");
                        } else if (pig.getAmount() > 0) {
                            pig.setAmount(pig.getAmount() - 1);
                            red.power();
                            System.out.println("1 babi biasa terbunuh.");
                        }
                    }
                    red.setAmount(red.getAmount() - 1);
                } else {
                    System.out.println("Red tidak tersedia/sudah habis. Silahkan coba lagi.");
                }
                break;
            case 2:
                if (yellow.getAmount() > 0) {
                    if (rand.nextInt(1 - 0 + 1) < 1 || glass.getAmount() > 1) {
                        glass.setAmount(glass.getAmount() - 2);
                        yellow.power();
                        System.out.println("2 kaca dihancurkan.");
                        if (pig.getAmount() > 0) {
                            pig.setAmount(pig.getAmount() - 1);
                            System.out.println("1 babi biasa terbunuh.");
                        }
                    } else {
                        if (wood.getAmount() > 0) {
                            wood.setAmount(wood.getAmount() - 1);
                            yellow.power();
                            System.out.println("1 kayu dihancurkan.");
                        } else if (stone.getAmount() > 0) {
                            stone.setHardness(stone.getHardness() - 2);
                            yellow.power();
                            System.out.println("Ketahanan batu berkurang.");
                        } else if (bucketpig.getAmount() > 0) {
                            pig.setAmount(bucketpig.getAmount() - 1);
                            yellow.power();
                            System.out.println("1 babi bertopi terbunuh.");
                        }
                    }
                    yellow.setAmount(yellow.getAmount() - 1);
                } else {
                    System.out.println("Chuck tidak tersedia/sudah habis. Silahkan coba lagi.");
                }
                break;
            case 3:
                if (blue.getAmount() > 0) {
                    if (rand.nextInt(1 - 0 + 1) < 1 || glass.getAmount() > 2) {
                        glass.setAmount(glass.getAmount() - 3);
                        blue.power();
                        System.out.println("3 kaca dihancurkan.");
                        if (pig.getAmount() > 0) {
                            pig.setAmount(pig.getAmount() - 1);
                            System.out.println("1 babi biasa terbunuh.");
                        }
                    } else {
                        if (wood.getAmount() > 0) {
                            wood.setAmount(wood.getAmount() - 1);
                            wood.setHardness(wood.getHardness() - 1);
                            blue.power();
                            System.out.println("1 (atau beberapa) kayu dihancurkan.");
                            if (pig.getAmount() > 0) {
                                pig.setAmount(pig.getAmount() - 1);
                                System.out.println("1 babi biasa terbunuh.");
                            }
                        } else if (stone.getAmount() > 0) {
                            stone.setHardness(stone.getHardness() - 1);
                            blue.power();
                            System.out.println("1 batu dihancurkan.");
                        } else if (pig.getAmount() > 1) {
                            pig.setAmount(pig.getAmount() - 2);
                            blue.power();
                            System.out.println("2 babi biasa terbunuh.");
                        }
                    }
                    blue.setAmount(blue.getAmount() - 1);
                } else {
                    System.out.println("Blues tidak tersedia/sudah habis. Silahkan coba lagi.");
                }
                break;
            case 4:
                if (black.getAmount() > 0) {
                    if (rand.nextInt(2 - 0 + 1) < 1 || stone.getAmount() > 1) {
                        stone.setAmount(stone.getAmount() - 2);
                        black.power();
                        System.out.println("2 batu dihancurkan.");
                        if (armorpig.getAmount() > 0) {
                            armorpig.setAmount(armorpig.getAmount() - 1);
                            System.out.println("1 babi berarmor terbunuh.");
                        }
                        if (bucketpig.getAmount() > 1) {
                            bucketpig.setAmount(bucketpig.getAmount() - 2);
                            System.out.println("2 babi bertopi terbunuh.");
                        }
                    } else if (rand.nextInt(2 - 0 + 1) == 1 && wood.getAmount() > 1) {
                        wood.setAmount(wood.getAmount() - 2);
                        black.power();
                        System.out.println("2 kayu dihancurkan.");
                        if (armorpig.getAmount() > 0) {
                            armorpig.setAmount(armorpig.getAmount() - 1);
                            System.out.println("1 babi berarmor terbunuh.");
                        }
                        if (bucketpig.getAmount() > 0) {
                            bucketpig.setAmount(bucketpig.getAmount() - 1);
                            System.out.println("1 babi bertopi terbunuh.");
                        }
                    } else if (rand.nextInt(2 - 0 + 1) > 1 && glass.getAmount() > 2) {
                        glass.setAmount(glass.getAmount() - 3);
                        black.power();
                        System.out.println("2 kayu dihancurkan.");
                        if (armorpig.getAmount() > 0) {
                            armorpig.setAmount(armorpig.getAmount() - 1);
                            System.out.println("1 babi berarmor terbunuh.");
                        }
                    } else {
                        if (armorpig.getAmount() > 1) {
                            armorpig.setAmount(armorpig.getAmount() - 2);
                            System.out.println("2 babi berarmor terbunuh.");
                        }

                        if (pig.getAmount() > 2) {
                            armorpig.setAmount(pig.getAmount() - 3);
                            System.out.println("3 babi biasa terbunuh.");
                        }
                    }
                    black.setAmount(black.getAmount() - 1);
                } else {
                    System.out.println("Bomb tidak tersedia/sudah habis. Silahkan coba lagi.");
                }
                break;
            case 5:
                if (white.getAmount() > 0) {
                    if (rand.nextInt(1 - 0 + 1) < 1 || glass.getAmount() > 2) {
                        glass.setAmount(glass.getAmount() - 3);
                        white.power();
                        System.out.println("3 kaca dihancurkan.");
                        if (armorpig.getAmount() > 0) {
                            armorpig.setAmount(armorpig.getAmount() - 1);
                            System.out.println("1 babi berarmor terbunuh.");
                        }
                        if (bucketpig.getAmount() > 0) {
                            bucketpig.setAmount(bucketpig.getAmount() - 1);
                            System.out.println("1 babi bertopi terbunuh.");
                        }
                    } else {
                        if (wood.getAmount() > 0) {
                            wood.setAmount(wood.getAmount() - 1);
                            wood.setHardness(wood.getHardness() - 1);
                            white.power();
                            System.out.println("1 (atau beberapa) kayu dihancurkan.");
                            if (bucketpig.getAmount() > 1) {
                                bucketpig.setAmount(bucketpig.getAmount() - 2);
                                System.out.println("2 babi bertopi terbunuh.");
                            }
                        } else if (stone.getAmount() > 0) {
                            stone.setAmount(stone.getAmount() - 1);
                            white.power();
                            System.out.println("1 batu dihancurkan.");
                            if (armorpig.getAmount() > 0) {
                                armorpig.setAmount(armorpig.getAmount() - 1);
                                System.out.println("1 babi berarmor terbunuh.");
                            }
                        } else if (pig.getAmount() > 1) {
                            pig.setAmount(pig.getAmount() - 2);
                            white.power();
                            System.out.println("2 babi biasa terbunuh.");
                        }
                    }
                    white.setAmount(white.getAmount() - 1);
                } else {
                    System.out.println("Matilda tidak tersedia/sudah habis. Silahkan coba lagi.");
                }
                break;
            default:
                System.out.println("Pilih yang benar! Jangan mengada-ada!");
                break;
        }
        if (pig.getAmount() != 0 || armorpig.getAmount() != 0 || bucketpig.getAmount() != 0)
            game();
        else if (pig.getAmount() == 0 && armorpig.getAmount() == 0 && bucketpig.getAmount() == 0)
            System.out.println("\nHore! anda telah memenangkan permainan!");
    }

    public void separator() {
        System.out.println("-|-");
    }

    public void heading(String title) {
        System.out.print("-| " + title + " |-");
    }

    public Blues getBlue() {
        return blue;
    }

    public void setBlue(Blues blue) {
        this.blue = blue;
    }

    public Bomb getBlack() {
        return black;
    }

    public void setBlack(Bomb black) {
        this.black = black;
    }

    public Chuck getYellow() {
        return yellow;
    }

    public void setYellow(Chuck yellow) {
        this.yellow = yellow;
    }

    public Matilda getWhite() {
        return white;
    }

    public void setWhite(Matilda white) {
        this.white = white;
    }

    public Red getRed() {
        return red;
    }

    public void setRed(Red red) {
        this.red = red;
    }

    public NormalPig getPig() {
        return pig;
    }

    public void setPig(NormalPig pig) {
        this.pig = pig;
    }

    public BucketPig getBucketpig() {
        return bucketpig;
    }

    public void setBucketpig(BucketPig bucketpig) {
        this.bucketpig = bucketpig;
    }

    public ArmorPig getArmorpig() {
        return armorpig;
    }

    public void setArmorpig(ArmorPig armorpig) {
        this.armorpig = armorpig;
    }

    public Glass getGlass() {
        return glass;
    }

    public void setGlass(Glass glass) {
        this.glass = glass;
    }

    public Wood getWood() {
        return wood;
    }

    public void setWood(Wood wood) {
        this.wood = wood;
    }

    public Stone getStone() {
        return stone;
    }

    public void setStone(Stone stone) {
        this.stone = stone;
    }
}
