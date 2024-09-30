public class Main {

    public static void main(String[] args) throws Exception{
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Race race= new Race();

        String[] carNames = inputView.receiveCarNames();
        int racingRound = inputView.receiveRacingRound(); 
        
        race.registerNameOfCars(carNames);

        resultView.displayOnlyResultMessage();

        for(int i=0; i<racingRound; i++){
            race.runSingleRound();
            resultView.displayCurrentResult(race.getCurrentResult());
        }

        resultView.displayWinner(race.getWinner());

    }


    
}
