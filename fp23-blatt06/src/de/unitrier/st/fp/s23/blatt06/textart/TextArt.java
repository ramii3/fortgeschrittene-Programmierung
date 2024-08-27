/*
 * Author: Sir Clexalot aka Master Clexington aka Kuenzlord aka Kuenzlinger der Boss
 * Year: 2021
 */

package de.unitrier.st.fp.s23.blatt06.textart;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

final class TextArt
{
    private final List<Character> textArtCharacters;
    private final int end;
    private int nextCharacterIndex = 0;

    TextArt(final List<Character> textArtCharacters)
    {
        this.textArtCharacters = textArtCharacters;
        this.end = textArtCharacters.size();
    }

    TextArt(final String fileName)
    {
        textArtCharacters = new ArrayList<>();

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)), "UTF-8")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                final char[] chars = line.toCharArray();
                //noinspection ForLoopReplaceableByForEach
                for (int i = 0; i < chars.length; i++)
                {
                    textArtCharacters.add(chars[i]);
                }
                textArtCharacters.add('\n');
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        end = textArtCharacters.size();
    }

    int getNextCharacterIndex()
    {
        if (nextCharacterIndex < end)
        {
            int ret = nextCharacterIndex;
            nextCharacterIndex = nextCharacterIndex + 1;
            return ret;
        }
        return -1;
    }

    char getCharacter(final int index)
    {
        if (index < 0 || index > end)
        {
            return '\0';
        }
        return textArtCharacters.get(index);
    }
}
