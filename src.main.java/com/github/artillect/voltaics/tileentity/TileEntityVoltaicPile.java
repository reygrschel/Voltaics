package com.github.artillect.voltaics.tileentity;

import com.github.artillect.voltaics.capability.Capabilities;
import com.github.artillect.voltaics.power.implementation.BaseEnergySource;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;

public class TileEntityVoltaicPile extends TileEntity implements ITickable {
	
	private BaseEnergySource container;
	
	public TileEntityVoltaicPile() {
		this.container = new BaseEnergySource(12, 20000, 20000, 20, 1200);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.container = new BaseEnergySource(compound.getCompoundTag("JouleContainer"));
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setTag("JouleContainer", this.container.serializeNBT());
		return super.writeToNBT(compound);
	}
	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}
	
	//Sided capabilities
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability (Capability<T> capability, EnumFacing facing) {
    	
    	if (capability == Capabilities.CAPABILITY_SOURCE) {
    		return (T) this.container;
    	}
            
        return super.getCapability(capability, facing);
    }
    
    @Override
    public boolean hasCapability (Capability<?> capability, EnumFacing facing) {
    	
    	if (capability == Capabilities.CAPABILITY_SOURCE) {
    		return true;
    	}
    	else return false;    
    }

    //TODO Many of these lines are very long, shorten
	@Override
	public void update() {

	}
}