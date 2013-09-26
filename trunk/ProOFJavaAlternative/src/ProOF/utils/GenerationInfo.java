/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProOF.utils;

/**
 *
 * @author ito
 */
public class GenerationInfo {

    private int relativePositionInPop;
    private int relativePopSize;
    private static long generation = 0;
    private long _currGeneration;

    public GenerationInfo() {
	_currGeneration = generation;
    }

    public GenerationInfo(int relativePositionInPop, int relativePopSize) {
	this.relativePositionInPop = relativePositionInPop;
	this.relativePopSize = relativePopSize;
	_currGeneration = generation;
    }

    public int getRelativePositionInPop() {
	return relativePositionInPop;
    }

    public void setRelativePositionInPop(int relativePositionInPop) {
	this.relativePositionInPop = relativePositionInPop;
    }

    public int getRelativePopSize() {
	return relativePopSize;
    }

    public void setRelativePopSize(int relativePopSize) {
	this.relativePopSize = relativePopSize;
    }

    public long getCurrGeneration() {
	return _currGeneration;
    }

    public void setInfo(int relativePos, int relativePopSize) {
	this.relativePopSize = relativePopSize;
	this.relativePositionInPop = relativePos;
    }

    public static void newGeneration() {
	generation++;
    }

    public static long getGlobalGeneration() {
	return generation;
    }
}
