public class Game {
    public static void main(String[] args) {
            
      Jar jar = new Jar();
      Prompter prompter = new Prompter(jar);
      
      prompter.administratorSetup();
      prompter.playerSetup();
      prompter.play();
      
      
    }
}
