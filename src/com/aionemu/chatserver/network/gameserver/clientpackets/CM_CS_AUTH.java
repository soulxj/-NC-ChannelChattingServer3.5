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


package com.aionemu.chatserver.network.gameserver.clientpackets;

import com.aionemu.chatserver.network.gameserver.GsAuthResponse;
import com.aionemu.chatserver.network.gameserver.GsClientPacket;
import com.aionemu.chatserver.network.gameserver.GsConnection;
import com.aionemu.chatserver.network.gameserver.GsConnection.State;
import com.aionemu.chatserver.network.gameserver.serverpackets.SM_GS_AUTH_RESPONSE;
import com.aionemu.chatserver.service.GameServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author ATracer
 */
public class CM_CS_AUTH extends GsClientPacket {

    private Logger log = LoggerFactory.getLogger(CM_CS_AUTH.class);
    /**
     * Password for authentication
     */
    private int unk;
    /**
     * Id of GameServer
     */
    private int gameServerId;
    /**
     * Default address for server
     */
    private byte[] aion;

    public CM_CS_AUTH(ByteBuffer buf, GsConnection connection) {
        super(buf, connection, 0x01);
    }

    @Override
    protected void readImpl() {
        unk = (byte) readC();
        aion = readB(4);
        gameServerId = readD();
    }

    @Override
    protected void runImpl() {
        GsAuthResponse resp = GameServerService.getInstance().registerGameServer(gameServerId,new String(aion, StandardCharsets.UTF_8));

        switch (resp) {
            case AUTHED:
                getConnection().setState(State.AUTHED);
                getConnection().sendPacket(new SM_GS_AUTH_RESPONSE(resp));
                log.info("Gameserver #" + gameServerId + " is now online.");
                break;
            case NOT_AUTHED:
                getConnection().sendPacket(new SM_GS_AUTH_RESPONSE(resp));
                break;
            case ALREADY_REGISTERED:
                log.info("Gameserver #" + gameServerId + " is already registered!");
                getConnection().sendPacket(new SM_GS_AUTH_RESPONSE(resp));
                break;
        }
    }
}