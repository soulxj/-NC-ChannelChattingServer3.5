/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 */


package com.aionemu.chatserver.network.gameserver.clientpackets;

import com.aionemu.chatserver.network.gameserver.GsClientPacket;
import com.aionemu.chatserver.network.gameserver.GsConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * @author SOULXJ
 */
public class CM_PING extends GsClientPacket {

    private static final Logger log = LoggerFactory.getLogger(CM_PING.class);
    private int unk;

    public CM_PING(ByteBuffer buf, GsConnection connection) {
        super(buf, connection, 0x02);
    }

    @Override
    protected void readImpl() {
        unk = readC(); ///unk
    }

    @Override
    protected void runImpl() {
        //log.error(this.toString());
    }

    @Override
    public String toString() {
        return "CM_PING{" +
                "unk=" + unk +
                '}';
    }
}

