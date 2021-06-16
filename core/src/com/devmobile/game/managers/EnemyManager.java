package com.devmobile.game.managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.devmobile.game.helpers.GameInfo;
import com.devmobile.game.objects.enemys.Octi;
import com.devmobile.game.objects.enemys.PokeyBub;
import com.devmobile.game.objects.enemys.RoboPumpkin;
import com.devmobile.game.objects.enemys.SpikeyBub;
import com.devmobile.game.objects.enemys.types.GenericEnemy;

public class EnemyManager {
    private Array<GenericEnemy> enemys;
    private ObjectMap<String, Integer> allNames;

    public EnemyManager(){
        reset();
        config();
    }

    //Atualiza todos inimigos
    public void update(){
        checkEnemys();
    }

    //Retira os inimigos do array
    public void reset(){
        enemys = new Array<>();
    }

    //Desenha todos os items no array e caso ele tiver sido usado retira ele do array
    public void  draw(SpriteBatch batch){
        for(int i = 0; i < enemys.size; i++){
            GenericEnemy enemy = enemys.get(i);
            if(enemy.isDead()){
                enemys.removeIndex(i);
            }
            else {
                enemy.draw(batch);
            }
        }
    }

    //Criar novos inimigos de acordo com a posição passada, precisa do tamanho do terreno
    public void enemyGeneration(int x, int y, int width){
        int num = MathUtils.random(0, 100);
        if(GameInfo.enemyChance >= num){
            String enemyType = getRandomName();
            GenericEnemy enemy = null;

                switch (enemyType) {
                    case "Octi":
                        enemy = new Octi(x, y, width);
                        break;
                    case "PokeyBub":
                        enemy = new PokeyBub(x, y, width);
                        break;
                    case "RoboPumpkin":
                        enemy = new RoboPumpkin(x, y, width);
                        break;
                    case "SpikeyBub":
                        enemy = new SpikeyBub(x, y, width);
                        break;
                }
                if (enemy != null) {
                    add(enemy);
                }
        }
    }

    //Adiciona um inimigo no array de inimigos
    private void add (GenericEnemy enemy){
        enemys.add(enemy);
    }

    //Verifica se o jogador está colidindo com um item
    private void checkEnemys(){
        for(GenericEnemy enemy : enemys){
            enemy.update();
        }
    }

    //Retorna um nome aleátorio baseado na chance no GameInfo
    private String getRandomName(){
        float num = 0f;
        String name = "";
        for (String key : allNames.keys()){
            float randomNum = MathUtils.random(0f, 1f);
            randomNum *= allNames.get(key);
            if(randomNum > num){
                num = randomNum;
                name = key;
            }
        }
        return name;
    }

    //Adiciona os nomes dos inimigos e suas chances
    private void config (){
        allNames = new ObjectMap<>();
        allNames.put("Octi", GameInfo.enemyOctiChance);
        allNames.put("PokeyBub", GameInfo.enemyPokeyBubChance);
        allNames.put("RoboPumpkin", GameInfo.enemyRoboPumpkinChance);
        allNames.put("SpikeyBub", GameInfo.enemySpikeyBubChance);
    }
}
