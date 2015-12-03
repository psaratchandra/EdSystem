package means.solution;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/note")
public class NoteResource
{
    private static Map<Integer, Note> DATA = new ConcurrentHashMap<>();
    private static AtomicInteger ID_COUNTER = new AtomicInteger();
    
    @PUT
    public Note create(Note note)
    {
        note.setId(ID_COUNTER.incrementAndGet());
        DATA.put(note.getId(), note);
        return note;
    }
    
    @GET
    public Collection<Note> getNotes()
    {
        return DATA.values();
    }
    
    @GET
    @Path("{noteId}")
    public Note get(@PathParam("noteId") int noteId)
    {
        Note found = DATA.get(noteId);
        if(found == null)
        {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return found;
    }
    
    @DELETE
    @Path("{noteId}")
    public void delete(@PathParam("noteId") int noteId)
    {
        Note found = DATA.remove(noteId);
        if(found == null)
        {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return;
    }
    
}
