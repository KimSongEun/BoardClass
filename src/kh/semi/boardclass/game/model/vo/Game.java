package kh.semi.boardclass.game.model.vo;

import java.sql.Date;

public class Game {

	private int gameNumber;
	private String gameKoName;
	private String gameEnName;
	private String gameCategory;
	private int gameView;
	private String gameAge;
	private String gamePlayer;
	private String gameTime;
	private int gamePrice;
	private int gameGrade;
	private Date gameDate;
	private int gameLevel;
	private String gameDesigner;
	private String gameWriter;
	private String gameBrand;
	private String gameReleaseDate;
	private int gameRank;
	private String gameLanguage;
	private String gameReview;
	private String gameImage;
	private String gameRuleImage;
	private String gameVideo;
	private String gamePlus;
	private int usedNum;

	public Game() {
		// TODO Auto-generated constructor stub
	}

	public Game(int gameNumber, String gameKoName, String gameEnName, String gameCategory, int gameView, String gameAge,
			String gamePlayer, String gameTime, int gamePrice, int gameGrade, Date gameDate, int gameLevel,
			String gameDesigner, String gameWriter, String gameBrand, String gameReleaseDate, int gameRank,
			String gameLanguage, String gameReview, String gameImage, String gameRuleImage, String gameVideo, String gamePlus, int usedNo) {
		super();
		this.gameNumber = gameNumber;
		this.gameKoName = gameKoName;
		this.gameEnName = gameEnName;
		this.gameCategory = gameCategory;
		this.gameView = gameView;
		this.gameAge = gameAge;
		this.gamePlayer = gamePlayer;
		this.gameTime = gameTime;
		this.gamePrice = gamePrice;
		this.gameGrade = gameGrade;
		
		this.gameDate = gameDate;
		this.gameLevel = gameLevel;
		this.gameDesigner = gameDesigner;
		this.gameWriter = gameWriter;
		this.gameBrand = gameBrand;
		this.gameReleaseDate = gameReleaseDate;
		this.gameRank = gameRank;
		this.gameLanguage = gameLanguage;
		this.gameReview = gameReview;
		this.gameImage = gameImage;
		this.gameRuleImage = gameRuleImage;
		this.gameVideo = gameVideo;
		this.gamePlus = gamePlus;
		this.usedNum = usedNo;
	}

	@Override
	public String toString() {
		return "Game [gameNumber=" + gameNumber + ", gameKoName=" + gameKoName + ", gameEnName=" + gameEnName
				+ ", gameCategory=" + gameCategory + ", gameView=" + gameView + ", gameAge=" + gameAge + ", gamePlayer="
				+ gamePlayer + ", gameTime=" + gameTime + ", gamePrice=" + gamePrice + ", gameGrade=" + gameGrade
				+ ", gameDate=" + gameDate + ", gameLevel=" + gameLevel + ", gameDesigner=" + gameDesigner
				+ ", gameWriter=" + gameWriter + ", gameBrand=" + gameBrand + ", gameReleaseDate=" + gameReleaseDate
				+ ", gameRank=" + gameRank + ", gameLanguage=" + gameLanguage + ", gameReview=" + gameReview
				+ ", gameImage=" + gameImage + ", gameRuleImage=" + gameRuleImage + ", gameVideo=" + gameVideo
				+ ", gamePlus=" + gamePlus + ", usedNum=" + usedNum + "]";
	}

	public String getGameRuleImage() {
		return gameRuleImage;
	}

	public void setGameRuleImage(String gameRuleImage) {
		this.gameRuleImage = gameRuleImage;
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

	public String getGameKoName() {
		return gameKoName;
	}

	public void setGameKoName(String gameKoName) {
		this.gameKoName = gameKoName;
	}

	public String getGameEnName() {
		return gameEnName;
	}

	public void setGameEnName(String gameEnName) {
		this.gameEnName = gameEnName;
	}

	public String getGameCategory() {
		return gameCategory;
	}

	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}

	public int getGameView() {
		return gameView;
	}

	public void setGameView(int gameView) {
		this.gameView = gameView;
	}

	public String getGameAge() {
		return gameAge;
	}

	public void setGameAge(String gameAge) {
		this.gameAge = gameAge;
	}

	public String getGamePlayer() {
		return gamePlayer;
	}

	public void setGamePlayer(String gamePlayer) {
		this.gamePlayer = gamePlayer;
	}

	public String getGameTime() {
		return gameTime;
	}

	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}

	public int getGamePrice() {
		return gamePrice;
	}

	public void setGamePrice(int gamePrice) {
		this.gamePrice = gamePrice;
	}

	public int getGameGrade() {
		return gameGrade;
	}

	public void setGameGrade(int gameGrade) {
		this.gameGrade = gameGrade;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public int getGameLevel() {
		return gameLevel;
	}

	public void setGameLevel(int gameLevel) {
		this.gameLevel = gameLevel;
	}

	public String getGameDesigner() {
		return gameDesigner;
	}

	public void setGameDesigner(String gameDesigner) {
		this.gameDesigner = gameDesigner;
	}

	public String getGameWriter() {
		return gameWriter;
	}

	public void setGameWriter(String gameWriter) {
		this.gameWriter = gameWriter;
	}

	public String getGameBrand() {
		return gameBrand;
	}

	public void setGameBrand(String gameBrand) {
		this.gameBrand = gameBrand;
	}

	public String getGameReleaseDate() {
		return gameReleaseDate;
	}

	public void setGameReleaseDate(String gameReleaseDate) {
		this.gameReleaseDate = gameReleaseDate;
	}

	public int getGameRank() {
		return gameRank;
	}

	public void setGameRank(int gameRank) {
		this.gameRank = gameRank;
	}

	public String getGameLanguage() {
		return gameLanguage;
	}

	public void setGameLanguage(String gameLanguage) {
		this.gameLanguage = gameLanguage;
	}

	public String getGameReview() {
		return gameReview;
	}

	public void setGameReview(String gameReview) {
		this.gameReview = gameReview;
	}

	public String getGameImage() {
		return gameImage;
	}

	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}

	public String getGameVideo() {
		return gameVideo;
	}

	public void setGameVideo(String gameVideo) {
		this.gameVideo = gameVideo;
	}

	public String getGamePlus() {
		return gamePlus;
	}

	public void setGamePlus(String gamePlus) {
		this.gamePlus = gamePlus;
	}

	public int getUsedNum() {
		return usedNum;
	}

	public void setUsedNum(int usedNum) {
		this.usedNum = usedNum;
	}


}
