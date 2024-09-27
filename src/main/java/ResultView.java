public class ResultView {

    public void displayOnlyResultMessage(){
        System.out.println("실행 결과");
    }
    
    public void displayCurrentResult(CarInfo[] carInfos){
        String outputText;
        
        for(CarInfo carInfo : carInfos){
            outputText = 
            carInfo.getName()
            +" : "
            +"-".repeat(carInfo.getDistance());

            System.out.println(outputText);
        }
        System.out.println("\n");
    }

    public void displayWinner(String[] winners){
        String resultText = String.join(", ",winners);
        
        System.out.println(resultText + "가 최종 우승했습니다.");
    }
    
}
