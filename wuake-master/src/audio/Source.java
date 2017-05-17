package audio;

import org.lwjgl.openal.AL10;
import org.lwjgl.util.vector.Vector3f;

public class Source
{

	private int sourceID;
	private int bufferID;

	public Source()
	{
		sourceID = AL10.alGenSources();
		AL10.alSourcef(sourceID, AL10.AL_ROLLOFF_FACTOR, 1f);
		AL10.alSourcef(sourceID, AL10.AL_REFERENCE_DISTANCE, 4);
		AL10.alSourcef(sourceID, AL10.AL_MAX_DISTANCE, Float.POSITIVE_INFINITY);
		setVolume(1);
		setPitch(1);
		setPosition(0, 0, 0);
	}

	public void play(int bufferID)
	{
		stop();
		if (this.bufferID != bufferID)
		{
			AL10.alSourcei(sourceID, AL10.AL_BUFFER, bufferID);
			this.bufferID = bufferID;
		}
		play();
	}

	public void play()
	{
		if (!isPlaying()) AL10.alSourcePlay(sourceID);
	}

	public void pause()
	{
		if (isPlaying()) AL10.alSourcePause(sourceID);
	}

	public void stop()
	{
		if (isPlaying()) AL10.alSourceStop(sourceID);
	}

	public boolean isPlaying()
	{
		return AL10.alGetSourcei(sourceID, AL10.AL_SOURCE_STATE) == AL10.AL_PLAYING;
	}

	public void setLooping(boolean looping)
	{
		AL10.alSourcei(sourceID, AL10.AL_LOOPING, looping ? AL10.AL_TRUE : AL10.AL_FALSE);
	}

	public void setVolume(float volume)
	{
		AL10.alSourcef(sourceID, AL10.AL_GAIN, volume);
	}

	public void setPitch(float pitch)
	{
		AL10.alSourcef(sourceID, AL10.AL_PITCH, pitch);
	}

	public void setPosition(float x, float y, float z)
	{
		AL10.alSource3f(sourceID, AL10.AL_POSITION, x, y, z);
	}

	public void setPosition(Vector3f v)
	{
		AL10.alSource3f(sourceID, AL10.AL_POSITION, v.getX(), v.getY(), v.getZ());
	}

	public void setVelocity(float x, float y, float z)
	{
		AL10.alSource3f(sourceID, AL10.AL_VELOCITY, x, y, z);
	}

	public void cleanUp()
	{
		stop();
		AL10.alDeleteSources(sourceID);
	}

}