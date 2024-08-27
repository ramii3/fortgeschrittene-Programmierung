package de.unitrier.st.fp.s23.blatt09.common;

import java.io.Serializable;
import java.util.List;

public record Handshake(int id, List<Message> messages) implements Serializable
{
}
