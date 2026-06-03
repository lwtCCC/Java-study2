package GAME1;

public class PokemonBattle {

    public static void main(String[] args) throws Exception {
        String player = "皮卡丘";
        String enemy = "妙蛙种子";

        int playerHP = 100;
        int enemyHP = 100;

        System.out.println("野生的 " + enemy + " 出现了！");
        sleep(1000);
        System.out.println("就决定是你了！" + player + "！");
        sleep(1000);

        // 战斗循环
        while (playerHP > 0 && enemyHP > 0) {

            // 玩家攻击
            System.out.println(player + " 使用了 十万伏特！");
            attackAnimation();
            enemyHP -= 20;
            if (enemyHP < 0) enemyHP = 0;
            System.out.println(enemy + " HP: " + enemyHP);
            sleep(1000);

            if (enemyHP == 0) break;

            // 敌人攻击
            System.out.println(enemy + " 使用了 藤鞭！");
            attackAnimation();
            playerHP -= 15;
            if (playerHP < 0) playerHP = 0;
            System.out.println(player + " HP: " + playerHP);
            sleep(1000);
        }

        // 结果
        if (playerHP > 0) {
            System.out.println(enemy + " 被击败了！");
        } else {
            System.out.println(player + " 倒下了...");
        }
    }

    // 攻击动画（简单版）
    public static void attackAnimation() throws Exception {
        String[] frames = {
                "⚡      ",
                "  ⚡    ",
                "    ⚡  ",
                "      ⚡",
                "    ⚡  ",
                "  ⚡    "
        };

        for (String f : frames) {
            System.out.print("\r" + f);
            Thread.sleep(150);
        }
        System.out.print("\r        \n");
    }

    // 延时函数
    public static void sleep(int ms) throws Exception {
        Thread.sleep(ms);
    }
}
