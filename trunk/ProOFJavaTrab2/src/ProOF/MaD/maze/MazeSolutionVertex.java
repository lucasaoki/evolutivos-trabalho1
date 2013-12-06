/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.MaD.maze;

import ProOF.MaD.maze.components.MazeVertex;
import ProOF.MaD.maze.utils.MazeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ito
 */
public class MazeSolutionVertex extends MazeSolution {

    ArrayList<MazeVertex> mazeVertex;

    public MazeSolutionVertex(Maze maze, int solutionLimitSize) {
        super(maze, solutionLimitSize);
        mazeVertex = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return mazeVertex.size();
    }

    @Override
    public boolean addVertex(MazeVertex vertex) {
        if (mazeVertex.size() >= solutionLimitSize) {
            System.out.println("Solution is full of vertex!");
            return false;
        } else {
            mazeVertex.add(vertex);
            totalDistanceValid = false;
            return true;
        }
    }

    @Override
    public boolean addDirection(Directions direction) {
        MazeVertex vtx;
        if (mazeVertex.size() >= solutionLimitSize) {
            System.out.println("Solution is full of vertex!");
            return false;
        } else {
            if (mazeVertex.size() >= 0) {
                if (mazeVertex.size() == 0) {
                    vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), maze.getStartVert(), direction);
                } else if (mazeVertex.size() == 1) {
                    vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), mazeVertex.get(mazeVertex.size() - 1), direction);
                } else {
                    vtx = MazeUtils.GetDestiny(maze, mazeVertex.get(mazeVertex.size() - 2), mazeVertex.get(mazeVertex.size() - 1), direction);
                }

                if (vtx != null) {
                    mazeVertex.add(vtx);
                    totalDistanceValid = false;
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
    }

    @Override
    public MazeVertex getVertexAt(int index) {
        if (index >= 0 && index < mazeVertex.size()) {
            return mazeVertex.get(index);
        } else {
            return null;
        }
    }

    @Override
    public Directions getDirectionAt(int index) {
        if (index >= 0 &&  index < mazeVertex.size() ) {
            if (index == 0) {
                return MazeUtils.GetDirections(maze.getStartVert().getLocation(), maze.getStartVert().getLocation(), mazeVertex.get(index).getLocation());
            } else if (index == 1) {
                return MazeUtils.GetDirections(maze.getStartVert().getLocation(), mazeVertex.get(index - 1).getLocation(), mazeVertex.get(index).getLocation());
            } else {
                return MazeUtils.GetDirections(mazeVertex.get(index - 2).getLocation(), mazeVertex.get(index - 1).getLocation(), mazeVertex.get(index).getLocation());
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean setVertexAt(int index, MazeVertex vertex) {
    	if(vertex != null ){
    		if (index >= 0 && index < mazeVertex.size()) {
    			mazeVertex.set(index, vertex);
    			totalDistanceValid = false;
    			return true;
    		} else {
    			return false;
    		}
    	}
    	return false;
    }

    @Override
    public boolean setDirectionAt(int index, Directions direction) {
        MazeVertex vtx;
        
        if(direction == Directions.RIGHT || direction == Directions.LEFT || direction == Directions.FORWARD || direction == Directions.BACKWARD ){
        	if (index >= 0 && index < mazeVertex.size() ) {
        		if (index == 0) {
        			vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), maze.getStartVert(), direction);
        		} else if (index == 1) {
        			vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), mazeVertex.get(index - 1), direction);
        		} else {
        			vtx = MazeUtils.GetDestiny(maze, mazeVertex.get(index - 2), mazeVertex.get(index - 1), direction);
        		}
        		if (vtx != null) {
        			totalDistanceValid = false;
        			return this.setVertexAt(index, vtx);
        		} else {
        			return false;
        		}

        	} else {
        		return false;
        	}
        }
        return false;
    }

    @Override
    public boolean addVertexAt(int index, MazeVertex vertex) {
        if (mazeVertex.size() >= solutionLimitSize) {
            System.out.println("Solution is full of vertex!");
            return false;
        } else {
            if (index >= 0 && index < mazeVertex.size()) {
                mazeVertex.add(index, vertex);
                totalDistanceValid = false;
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean addDirectionAt(int index, Directions direction) {
        MazeVertex vtx;

        if (mazeVertex.size() >= solutionLimitSize) {
            System.out.println("Solution is full of vertex!");
            return false;
        } else {
        	if(direction == Directions.RIGHT || direction == Directions.LEFT || direction == Directions.FORWARD || direction == Directions.BACKWARD ){
        		if (index >= 0 && index < mazeVertex.size()) {
        			if (index == 0) {
        				vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), maze.getStartVert(), direction);
        			} else if (index == 1) {
        				vtx = MazeUtils.GetDestiny(maze, maze.getStartVert(), mazeVertex.get(index - 1), direction);
        			} else {
        				vtx = MazeUtils.GetDestiny(maze, mazeVertex.get(index - 2), mazeVertex.get(index - 1), direction);
        			}

        			if (vtx != null) {
        				totalDistanceValid = false;
        				return this.addVertexAt(index, vtx);
        			} else {
        				return false;
        			}
        		} else {
        			return false;
        		}
        	}
        	return false;
        }
    }

    @Override
    public boolean addVertexRange(List<MazeVertex> vertices) {

        if (vertices == null) {
            System.out.println("MazeSolutionVertex.addVertexRange: ERROR: Null Parameter.");
            return false;
        } else {
            if (mazeVertex.size() + vertices.size() > solutionLimitSize ) {
                System.out.println("Solution is full of vertex!");
                return false;
            } else {
                for (int c = 0; c < vertices.size(); c++) {
                    mazeVertex.add(vertices.get(c));
                }
                totalDistanceValid = false;
                return true;
            }
        }
    }

    @Override
    public boolean addDirectionRange(List<Directions> directions) {
        boolean res = false;

        if (directions != null) {
            if (mazeVertex.size() + directions.size() >= solutionLimitSize) {
                for (int i = 0; i < directions.size(); i++) {
                    res = this.addDirection(directions.get(i));
                }
                totalDistanceValid = false;
                return res;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean removeAt(int index) {
        if (index >= 0 && index < mazeVertex.size()) {
            mazeVertex.remove(index);
            totalDistanceValid = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeRange(int indexStart, int indexEnd) {
        if (indexStart >= 0 && indexStart < mazeVertex.size() && indexEnd >= 0 && indexEnd < mazeVertex.size()) {
            if (indexEnd > indexStart) {

                for (int i = indexStart; i < indexEnd + 1; i++) {
                    mazeVertex.remove(indexStart);
                }
                totalDistanceValid = false;
                return true;
            } else {

                for (int i = indexEnd; i < indexStart + 1; i++) {
                    mazeVertex.remove(indexEnd);
                }
                totalDistanceValid = false;
                return true;

            }
        } else {
            return false;
        }
    }

    @Override
    public boolean addVertexRangeAt(int indexStart, List<MazeVertex> vertices) {
        if (mazeVertex.size() + vertices.size() > solutionLimitSize) {
            System.out.println("Solution is full of vertex!");
            return false;
        } else {
            if (indexStart >= 0 && indexStart < mazeVertex.size()) {
                for (int c = vertices.size() - 1;  c >= 0; c--) {
                    mazeVertex.add(indexStart, vertices.get(c));
                }
                totalDistanceValid = false;
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean addDirectionRangeAt(int indexStart, List<Directions> directions) {

        int index = 0;

        if (directions == null) {
            System.out.println("MazeSolutionVertex.addDirectionRangeAt: ERROR: Null Parameter.");
            return false;
        }

        if (mazeVertex.size() + directions.size() >= solutionLimitSize) {
            System.out.println("Solution is full of vertex!");
            return false;
        } else {
            if (indexStart >= 0 && indexStart < mazeVertex.size()) {
                for (int i = indexStart; i < indexStart + directions.size(); i++) {
                    this.addDirectionAt(i, directions.get(index++));
                }
                totalDistanceValid = false;
                return true;
            }
        }

        return false;
    }

    @Override
    public List<MazeVertex> getVertexRange(int indexStart, int indexEnd) {

    	if (indexEnd >= 0 && indexEnd < mazeVertex.size() && indexStart >= 0 && indexStart < mazeVertex.size()) {
    		if (indexEnd > indexStart) {
    			ArrayList<MazeVertex> result = new ArrayList<>();
    			for (int c = indexStart; c <= indexEnd; c++) {
    				result.add(mazeVertex.get(c));
    			}
    			return result;
    		} else {
    			ArrayList<MazeVertex> result = new ArrayList<>();
    			for (int c = indexStart; c <= indexEnd; c++) {
    				result.add(mazeVertex.get(c));
    			}

    			Collections.reverse(result);
    			return result;
    		}
    	}
    	return null;
    }

    @Override
    public List<Directions> getDirectionsRange(int indexStart, int indexEnd) {
        List<Directions> directions = new ArrayList<Directions>();

        if (indexEnd >= 0 && indexEnd < mazeVertex.size() && indexStart >= 0 && indexStart < mazeVertex.size()) {
        	if (indexStart < indexEnd) {
        		for (int i = indexStart; i < indexEnd + 1; i++) {
        			directions.add(this.getDirectionAt(i));
        		}
        		return directions;
        	} else {
        		for (int i = indexStart; i > indexEnd - 1; i--) {
        			directions.add(this.getDirectionAt(i));
        		}
        		return directions;
        	}
        }
        return null;
    }

    @Override
    public void Copy(MazeSolution mazesol) {
        if (mazesol instanceof MazeSolutionVertex) {
            MazeSolutionVertex m = (MazeSolutionVertex) mazesol;

            this.totalDistance = m.totalDistance;
            this.totalDistanceValid = m.totalDistanceValid;
            this.mazeVertex.clear();

            for (int c = 0; c < m.mazeVertex.size(); c++) {
                this.mazeVertex.add(m.mazeVertex.get(c));
            }

        }
    }

    @Override
    public boolean validate(){
        MazeVertex current = maze.getStartVert();
        MazeVertex last = current;
        MazeVertex new_vertex;
        if (!flag) {
            while (maze.getEdge(current, this.getVertexAt(0)) == null) {
                new_vertex = repair(current, last);
                if (new_vertex == null) {
                    this.removeRange(0, this.getSize() - 1);
                    return true;
                }
                this.setVertexAt(0, new_vertex);
            }
            for (int c = 0; c < this.getSize() - 1; c++) {
                current = this.getVertexAt(c);
                while (maze.getEdge(current, this.getVertexAt(c + 1)) == null) {
                    new_vertex = repair(current, last);
                    if (new_vertex == null) {
                        this.removeRange(c + 1, this.getSize() - 1);
                        return true;
                    }
                    this.setVertexAt(c + 1, new_vertex);
                }
                last = current;
            }
            return true;
        } else {
            if (maze.getEdge(current, this.getVertexAt(0)) == null) {
                this.removeRange(0, this.getSize() - 1);
                return true;
            }
            for (int c = 0; c < this.getSize() - 1; c++) {
                current = this.getVertexAt(c);
                if (maze.getEdge(current, this.getVertexAt(c+1)) == null) {
                    this.removeRange(c+1, this.getSize() - 1);
                    return true;
                }
            }
        }
        return true;
    }

    public MazeVertex repair(MazeVertex current, MazeVertex last){
        List<MazeVertex> vertex_list = maze.getConnectedVertices(current);
        Random rand_ = new Random(System.currentTimeMillis());
        if (last != current) {
            vertex_list.remove(vertex_list.indexOf(last));
        }
        if (vertex_list.size() < 1) {
            return null;
        } else {
            return vertex_list.get(rand_.nextInt(vertex_list.size()));
        }
    }
}
