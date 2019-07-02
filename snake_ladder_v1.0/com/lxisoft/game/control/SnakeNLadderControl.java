package com.lxisoft.game.control;
import com.lxisoft.game.model.*;
import java.util.*;
import java.util.logging.*;
/**
*This class is used as a control class for SnakeNLadder
*
*@author AryaVineesh
*
*@version 1.0
*
*Date Modified:02/07/2019
*/
public class SnakeNLadderControl
{
	/**
	*Reference Logger class to get log messages
	*/
	private static final Logger log=Logger.getLogger(SnakeNLadderControl.class.getName());
	
	SnakeNLadder game;
	
	public SnakeNLadderControl()
	{
		log.setLevel(Level.WARNING);
	}
	
	public void createBoard(SnakeNLadder game)
	{
		
		Board board=new Board();
		placeCells(board);
		placeSnakes(board);
		placeLadders(board);
		game.setBoard(board);
	}
	
	public void placeCells(Board board)
	{
		Cell[][] cellArray=new Cell[10][10];
		int x=100;
		for(int i=0;i<10;i++)
		{
			if(i%2==0)
			{
				for(int j=0;j<10;j++)
				{
					cellArray[i][j]=new Cell();
					cellArray[i][j].setCellNumber(x);
					x--;
				}
				x=x-10;
			}
			else
			{
				int temp=x+1;
				for(int j=0;j<10;j++)
				{
					cellArray[i][j]=new Cell();
					cellArray[i][j].setCellNumber(temp);
					temp++;
				}
			}
		}
		board.setCells(cellArray);
	}
	
	public void placeSnakes(Board board)
	{
		ArrayList<Snake> snakes=new ArrayList<Snake>();
		for(int i=0;i<8;i++)
		{
			snakes.add(new Snake());
			int rand1=getRandomCellNumber(board);
			int rand2=getRandomCellNumber(board);
			if(rand1>rand2)
			{
				snakes.get(i).setHeadPosition(rand1);
				snakes.get(i).setTailPosition(rand2);
			}
			else
			{
				snakes.get(i).setHeadPosition(rand2);
				snakes.get(i).setTailPosition(rand1);
			}
			System.out.println(" "+snakes.get(i).getHeadPosition());
			System.out.println(" "+snakes.get(i).getTailPosition());
		}
		board.setSnakes(snakes);
	}
	
	public void placeLadders(Board board)
	{
		ArrayList<Ladder> ladders=new ArrayList<Ladder>();
		for(int i=0;i<8;i++)
		{
			ladders.add(new Ladder());
			int rand1=getRandomCellNumber(board);
			int rand2=getRandomCellNumber(board);
			if(rand1<rand2)
			{
				ladders.get(i).setStartingPoint(rand1);
				ladders.get(i).setEndPoint(rand2);
			}
			else
			{
				ladders.get(i).setStartingPoint(rand2);
				ladders.get(i).setEndPoint(rand1);
			}
			
			
			System.out.println(" "+ladders.get(i).getStartingPoint());
			System.out.println(" "+ladders.get(i).getEndPoint());
		}
		board.setLadders(ladders);
	}
	
	public int getRandomCellNumber(Board board)
	{
		int i=(int)(Math.random()*9);
		int j=(int)(Math.random()*9);
		Cell[][] cellArray=new Cell[10][10];
		cellArray=board.getCells();
		return cellArray[i][j].getCellNumber();
	}
	
	public void playGame(SnakeNLadder game)
	{
		ArrayList<Player> playerList=game.getPlayers();
		Scanner sc=new Scanner(System.in);
		Dice dice=game.getDice();
		for(int j=0;j<playerList.size();j++)
		{
			playerList.get(j).setIsAlive(false);
			playerList.get(j).setPlayerPosition(0);
		}
		do
		{
			
			for(int i=0;i<playerList.size();i++)
			{
				System.out.println("player "+(i+1)+" ,"+playerList.get(i).getPlayerName()+"is rolling the dice...");
				System.out.println("press any key to roll the dice:");
				String c=sc.next();
				
				int random=dice.getRandomDiceNumber();
				System.out.println("Dice number is "+random);
				boolean status=playerList.get(i).getIsAlive();
				if(playerList.get(i).getPlayerPosition()==0)
				{
					if(random==1 || random==6 && status==false)
					{
						playerList.get(i).setIsAlive(true);
					}
					else
					{
						playerList.get(i).setIsAlive(false);
					}
				}
				
				if(playerList.get(i).getIsAlive()==true)
				{
					int currentPositon=playerList.get(i).getPlayerPosition();
					int newPosition=currentPositon+random;
					playerList.get(i).setPlayerPosition(newPosition);
					System.out.println(" position of "+playerList.get(i).getPlayerName()+" is "+playerList.get(i).getPlayerPosition());
				}
			}
		}while(true);
	}
	
	public void checkResult()
	{
		
	}
}