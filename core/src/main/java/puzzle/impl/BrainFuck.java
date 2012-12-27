package com.orwashere.puzzle.impl;

import com.orwashere.puzzle.Puzzle;

/**
 * Created by IntelliJ IDEA.
 * User: fdirlikl
 * Date: 12/21/12
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class BrainFuck implements Puzzle {
    private String inputString;
    private Integer memorySize;
    private String solution;
    
    public BrainFuck(String inputString,int memorySize)
    {
        this.inputString = inputString;
        this.memorySize = memorySize;
    }

    public BrainFuck()
    {

    }

    public void solve()
    {
        Integer currentCellNo = 0;
        Integer testArrayValue = 0;
        int[] memory = new int[memorySize];
        StringBuilder solBuilder = new StringBuilder();

        char [] operands = {'<','>','+','-','.','[',']'};


        char [] testArray = this.inputString.toCharArray();
        Integer commandLength = testArray.length;

        while(testArrayValue < commandLength || (testArrayValue == commandLength-1 && testArray[testArrayValue] == ']'))
        {
            if(testArray[testArrayValue] == '<')
            {
                testArrayValue = testArrayValue + 1;
                currentCellNo = currentCellNo - 1;
            }
            else if(testArray[testArrayValue] == '>')
            {
                testArrayValue = testArrayValue + 1;
                currentCellNo = currentCellNo + 1;
            }
            else if(testArray[testArrayValue] == '+')
            {
                testArrayValue = testArrayValue + 1;
                memory[currentCellNo] = memory[currentCellNo] + 1;
            }
            else if(testArray[testArrayValue] == '-')
            {
                testArrayValue = testArrayValue + 1;
                memory[currentCellNo] = memory[currentCellNo] -1;
            }
            else if(testArray[testArrayValue] == '.')
            {
                testArrayValue = testArrayValue + 1;
                solBuilder.append(Character.toChars(memory[currentCellNo]));
            }
            else if(testArray[testArrayValue] == '[')
            {
                if(memory[currentCellNo] == 0)
                {
                    while(testArray[testArrayValue] != ']')
                    {
                        testArrayValue = testArrayValue + 1;
                    }
                }
                else
                {
                    testArrayValue = testArrayValue + 1;
                }
            }
            else if(testArray[testArrayValue] == ']')
            {
                if(memory[currentCellNo] != 0)
                {
                    while(testArray[testArrayValue] != '[')
                    {
                        testArrayValue = testArrayValue - 1;
                    }
                }
                else
                {
                    testArrayValue = testArrayValue + 1;
                }
            }
        }
        this.solution = solBuilder.toString();
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public Integer getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(Integer memorySize) {
        this.memorySize = memorySize;
    }

    public String getSolution() {
        if(solution == null)
        {
            throw new RuntimeException("getSolution called before puzzle solved");
        }
        return solution;
    }
}
