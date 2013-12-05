package ProOF.MaD.maze.utils;

import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Set;

import ProOF.MaD.maze.Directions;
import ProOF.MaD.maze.Maze;
import ProOF.MaD.maze.components.MazeEdge;
import ProOF.MaD.maze.components.MazeVertex;

public class MazeUtils {
	
	static public Directions GetDirections(Double previous, Double current, Double next){
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
	
	static public MazeVertex GetDestiny( Maze maze, MazeVertex previous, MazeVertex current, Directions direction ){
		
		Set<MazeEdge> edges;
		MazeEdge[] edges_array;
		MazeVertex target;
		
		edges = maze.edgesOf(current);
		edges_array = edges.toArray(new MazeEdge[0]);
		
		if(current.equals(previous)){
			
			if( direction == Directions.RIGHT ){
				for (int i = 0; i < edges_array.length; i++) {
					target = edges_array[i].getV1();
					if( target.equals(current) ){
						target = edges_array[i].getV2();
					}
					
					if( Math.abs( target.getX() - current.getX() ) > Math.abs( target.getY() - current.getY() ) ){
						if( target.getX() > current.getX() ){
							return target;
						}
					}
				}
				return null;
			}
			if( direction == Directions.LEFT ){
				for (int i = 0; i < edges_array.length; i++) {
					target = edges_array[i].getV1();
					if( target.equals(current) ){
						target = edges_array[i].getV2();
					}
					
					if( Math.abs( target.getX() - current.getX() ) > Math.abs( target.getY() - current.getY() ) ){
						if( target.getX() < current.getX() ){
							return target;
						}
					}
				}
				return null;
			}
			if( direction == Directions.FORWARD ){
				for (int i = 0; i < edges_array.length; i++) {
					target = edges_array[i].getV1();
					if( target.equals(current) ){
						target = edges_array[i].getV2();
					}
					
					if( Math.abs( target.getY() - current.getY() ) > Math.abs( target.getX() - current.getX() ) ){
						if( target.getY() < current.getY() ){
							return target;
						}
					}
				}
				return null;
			}
			if( direction == Directions.BACKWARD ){
				for (int i = 0; i < edges_array.length; i++) {
					target = edges_array[i].getV1();
					if( target.equals(current) ){
						target = edges_array[i].getV2();
					}
					
					if( Math.abs( target.getY() - current.getY() ) > Math.abs( target.getX() - current.getX() ) ){
						if( target.getY() > current.getY() ){
							return target;
						}
					}
				}
				return null;
			}
		} else {
			if( Math.abs( current.getX() - previous.getX() ) > Math.abs( current.getY() - previous.getY() ) ){
				if( current.getX() > previous.getX() ){
					if( direction == Directions.RIGHT ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getY() - current.getY() ) > Math.abs( target.getX() - current.getX() ) ){
								if( target.getY() > current.getY() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.LEFT ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getY() - current.getY() ) > Math.abs( target.getX() - current.getX() ) ){
								if( target.getY() < current.getY() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.FORWARD ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getX() - current.getX() ) > Math.abs( target.getY() - current.getY() ) ){
								if( target.getX() > current.getX() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.BACKWARD ){
						return previous;
					}
				} else {
					if( direction == Directions.RIGHT ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getY() - current.getY() ) > Math.abs( target.getX() - current.getX() ) ){
								if( target.getY() < current.getY() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.LEFT ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getY() - current.getY() ) > Math.abs( target.getX() - current.getX() ) ){
								if( target.getY() > current.getY() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.FORWARD ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getX() - current.getX() ) > Math.abs( target.getY() - current.getY() ) ){
								if( target.getX() < current.getX() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.BACKWARD ){
						return previous;
					}
				}
			} else {
				if( current.getY() > previous.getY() ){
					if( direction == Directions.RIGHT ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getX() - current.getX() ) > Math.abs( target.getY() - current.getY() ) ){
								if( target.getX() < current.getX() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.LEFT ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getX() - current.getX() ) > Math.abs( target.getY() - current.getY() ) ){
								if( target.getX() > current.getX() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.FORWARD ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getY() - current.getY() ) > Math.abs( target.getX() - current.getX() ) ){
								if( target.getY() > current.getY() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.BACKWARD ){
						return previous;
					}
				} else {
					if( direction == Directions.RIGHT ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getX() - current.getX() ) > Math.abs( target.getY() - current.getY() ) ){
								if( target.getX() > current.getX() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.LEFT ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getX() - current.getX() ) > Math.abs( target.getY() - current.getY() ) ){
								if( target.getX() < current.getX() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.FORWARD ){
						for (int i = 0; i < edges_array.length; i++) {
							target = edges_array[i].getV1();
							if( target.equals(current) ){
								target = edges_array[i].getV2();
							}
							
							if( Math.abs( target.getY() - current.getY() ) > Math.abs( target.getX() - current.getX() ) ){
								if( target.getY() < current.getY() ){
									return target;
								}
							}
						}
						return null;
					}
					if( direction == Directions.BACKWARD ){
						return previous;
					}
				}
			}
		}
		System.out.println("MazeUtils.GetDestiny: ERROR! Reached End of Function! Default return: null");		
		return null;
	}
	
	static public MazeVertex getVertex( Maze maze, ArrayList<Directions> directions, int index){
		
		MazeVertex vtx1, vtx2, tmp;
		
		vtx1 = maze.getStartVert();
		vtx2 = vtx1;
		
		for (int i = 0; i < index+1; i++) {
			if( i == 0 ){
				vtx1 = MazeUtils.GetDestiny(maze, vtx1, vtx1, directions.get(i));
			}
			if( i > 0 ){
				tmp = vtx1;
				vtx1 = MazeUtils.GetDestiny(maze, vtx2, vtx1, directions.get(i));
				vtx2 = tmp;
			}
		}
		
		return vtx1;
	}
	

}
