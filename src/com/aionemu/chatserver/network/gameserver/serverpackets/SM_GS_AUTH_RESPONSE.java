/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 * <p>
 * Aion-Lightning is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * Aion-Lightning is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details. *
 * You should have received a copy of the GNU General Public License
 * along with Aion-Lightning.
 * If not, see <http://www.gnu.org/licenses/>.
 */


package com.aionemu.chatserver.network.gameserver.serverpackets;

import com.aionemu.chatserver.network.gameserver.GsAuthResponse;
import com.aionemu.chatserver.network.gameserver.GsConnection;
import com.aionemu.chatserver.network.gameserver.GsServerPacket;

/**
 * @author soulxj
 */
public class SM_GS_AUTH_RESPONSE extends GsServerPacket {

    private GsAuthResponse response;

    public SM_GS_AUTH_RESPONSE(GsAuthResponse resp) {
        this.response = resp;
    }

    @Override
    protected void writeImpl(GsConnection con) {
        writeC(0x7);
        writeC(response.getResponseId());//ret?
        writeH(0x01);
        writeH(0x01);

    }
}
