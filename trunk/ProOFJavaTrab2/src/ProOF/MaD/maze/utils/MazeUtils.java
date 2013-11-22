package ProOF.MaD.maze.utils;

import java.awt.geom.Point2D.Double;

import ProOF.MaD.maze.Directions;
import ProOF.MaD.maze.components.MazeVertex;

public class MazeUtils {
	
	public Directions GetDirections(Double previous, Double current, Double next){
		if( (previous.x == current.x) && (previous.y == current.y) ){
			if( Math.abs( next.y - current.y ) > Math.abs( next.x - current.x ) ){
				if( next.y < current.y ){
					return Directions.FORWARD;
				} else {
					return Directions.BACKWARD;
				}
				
			} else {
				if( next.x < current.x ){
					return Directions.LEFT;
				} else {
					return Directions.RIGHT;
				}
			}
			
		} else {
			if( Math.abs( previous.x - current.x ) > Math.abs( previous.y - current.y ) ){
				if( Math.abs( current.x - next.x ) > Math.abs( current.y - next.y ) ){
					if( ( current.x > previous.x ) && ( next.x > current.x ) ){
						return Directions.FORWARD;
					}
					if( ( current.x < previous.x ) && ( next.x < current.x ) ){
						return Directions.FORWARD;
					}
					if( ( current.x < previous.x ) && ( next.x > current.x ) ){
						return Directions.BACKWARD;
					}
					if( ( current.x > previous.x ) && ( next.x < current.x ) ){
						return Directions.BACKWARD;
					}
				} else {
					if( (current.x > previous.x) && (next.y > current.y) ){
						return Directions.RIGHT;
					}
					if( (current.x > previous.x) && (next.y < current.y) ){
						return Directions.LEFT;
					}
					if( (current.x < previous.x) && (next.y > current.y) ){
						return Directions.LEFT;
					}
					if( (current.x < previous.x) && (next.y < current.y) ){
						return Directions.RIGHT;
					}
				}
			} else {
				if( Math.abs( current.x - next.x ) > Math.abs( current.y - next.y ) ){
					if( ( current.y > previous.y ) && ( next.x > current.x ) ){
						return Directions.LEFT;
					}
					if( ( current.y < previous.y ) && ( next.x < current.x ) ){
						return Directions.LEFT;
					}
					if( ( current.y < previous.y ) && ( next.x > current.x ) ){
						return Directions.RIGHT;
					}
					if( ( current.y > previous.y ) && ( next.x < current.x ) ){
						return Directions.RIGHT;
					}
				} else {
					if( ( current.y > previous.y ) && ( next.y > current.y ) ){
						return Directions.FORWARD;
					}
					if( ( current.y > previous.y ) && ( next.y < current.y ) ){
						return Directions.BACKWARD;
					}
					if( ( current.y < previous.y ) && ( next.y > current.y ) ){
						return Directions.BACKWARD;
					}
					if( ( current.y < previous.y ) && ( next.y < current.y ) ){
						return Directions.FORWARD;
					}
				}
			}
		}
		System.out.println("MazeUtils.GetDirections: ERROR! No direction found! Default: FORWARD");
		return Directions.FORWARD;
	}
	
//	public MazeVertex GetDestiny( MazeVertex previous, MazeVertex current, Directions direction ){
//		
//		if(current.equals(previous)){
//			
//		}
//	}
	

}
