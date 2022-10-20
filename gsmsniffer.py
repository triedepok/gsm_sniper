#!/usr/bin/env python2
# -*- coding: utf-8 -*-
##################################################
# GNU Radio Python Flow Graph
# Title: Gsm Rtl
# Author: Trie
# Generated: Tue Mar  1 23:16:12 2016
##################################################

from gnuradio import eng_notation
from gnuradio import gr
from gnuradio.eng_option import eng_option
from gnuradio.filter import firdes
from optparse import OptionParser
import grgsm
import osmosdr
import pmt
import time

import threading
import MySQLdb


class gsm_rtl(gr.top_block):

    def __init__(self, fc=0, g_slider=0, gain=60, ppm=0, samp_rate=2000000.052982):
        gr.top_block.__init__(self, "Gsm Rtl")
        
        ##################################################
        # Parameters
        ##################################################
        self.fc = fc
        self.g_slider = g_slider
        self.gain = gain
        self.ppm = ppm
        self.samp_rate = samp_rate

        ##################################################
        # Variables
        ##################################################
        self.SDCCH = SDCCH = 6
        self.SACCH = SACCH = 0x80
        self.RACH = RACH = 3
        self.PCH = PCH = 5
        self.CCCH = CCCH = 2
        self.BCCH = BCCH = 1
        self.AGCH = AGCH = 4

        ##################################################
        # Blocks
        ##################################################
        self.rtlsdr_source_0 = osmosdr.source( args="numchan=" + str(1) + " " + "" )
        self.rtlsdr_source_0.set_sample_rate(samp_rate)
        self.rtlsdr_source_0.set_center_freq(fc, 0)
        self.rtlsdr_source_0.set_freq_corr(0, 0)
        self.rtlsdr_source_0.set_dc_offset_mode(0, 0)
        self.rtlsdr_source_0.set_iq_balance_mode(2, 0)
        self.rtlsdr_source_0.set_gain_mode(False, 0)
        self.rtlsdr_source_0.set_gain(gain, 0)
        self.rtlsdr_source_0.set_if_gain(20, 0)
        self.rtlsdr_source_0.set_bb_gain(20, 0)
        self.rtlsdr_source_0.set_antenna("", 0)
        self.rtlsdr_source_0.set_bandwidth(0, 0)
          
        self.gsm_universal_ctrl_chans_demapper_0 = grgsm.universal_ctrl_chans_demapper(0, ([2,6,12,16,22,26,32,36,42,46]), ([BCCH,CCCH,CCCH,CCCH,CCCH,CCCH,CCCH,CCCH,CCCH,CCCH]))
        self.gsm_receiver_0 = grgsm.receiver(4, ([0]), ([]))
        self.gsm_input_0 = grgsm.gsm_input(
            ppm=0,
            osr=4,
            fc=fc,
            samp_rate_in=samp_rate,
        )
        self.gsm_imsi_dumper_0 = grgsm.imsi_dumper("root", "skm2010", "imsi_dump", "imsi", "localhost", 3306)
        self.gsm_control_channels_decoder_0 = grgsm.control_channels_decoder()
        self.gsm_clock_offset_control_0 = grgsm.clock_offset_control(fc)

        ##################################################
        # Connections
        ##################################################
        self.msg_connect((self.gsm_clock_offset_control_0, 'ppm'), (self.gsm_input_0, 'ppm_in'))    
        self.msg_connect((self.gsm_control_channels_decoder_0, 'msgs'), (self.gsm_imsi_dumper_0, 'msgs'))     
        self.msg_connect((self.gsm_receiver_0, 'measurements'), (self.gsm_clock_offset_control_0, 'measurements'))    
        self.msg_connect((self.gsm_receiver_0, 'C0'), (self.gsm_universal_ctrl_chans_demapper_0, 'bursts'))    
        self.msg_connect((self.gsm_universal_ctrl_chans_demapper_0, 'bursts'), (self.gsm_control_channels_decoder_0, 'bursts'))    
        self.connect((self.gsm_input_0, 0), (self.gsm_receiver_0, 0))    
        self.connect((self.rtlsdr_source_0, 0), (self.gsm_input_0, 0))
        print "Frequency: %d" % self.fc
        
    def get_fc(self):
        return self.fc

    def set_fc(self, fc):
        self.fc = fc
        self.gsm_input_0.set_fc(self.fc)
        self.rtlsdr_source_0.set_center_freq(self.fc, 0)
        print "def set_fc: %d" % self.fc

    def get_g_slider(self):
        return self.g_slider

    def set_g_slider(self, g_slider):
        self.g_slider = g_slider

    def get_gain(self):
        return self.gain

    def set_gain(self, gain):
        self.gain = gain
        self.rtlsdr_source_0.set_gain(self.gain, 0)

    def get_ppm(self):
        return self.ppm

    def set_ppm(self, ppm):
        self.ppm = ppm

    def get_samp_rate(self):
        return self.samp_rate

    def set_samp_rate(self, samp_rate):
        self.samp_rate = samp_rate
        self.gsm_input_0.set_samp_rate_in(self.samp_rate)
        self.rtlsdr_source_0.set_sample_rate(self.samp_rate)

    def get_SDCCH(self):
        return self.SDCCH

    def set_SDCCH(self, SDCCH):
        self.SDCCH = SDCCH

    def get_SACCH(self):
        return self.SACCH

    def set_SACCH(self, SACCH):
        self.SACCH = SACCH

    def get_RACH(self):
        return self.RACH

    def set_RACH(self, RACH):
        self.RACH = RACH

    def get_PCH(self):
        return self.PCH

    def set_PCH(self, PCH):
        self.PCH = PCH

    def get_CCCH(self):
        return self.CCCH

    def set_CCCH(self, CCCH):
        self.CCCH = CCCH

    def get_BCCH(self):
        return self.BCCH

    def set_BCCH(self, BCCH):
        self.BCCH = BCCH

    def get_AGCH(self):
        return self.AGCH

    def set_AGCH(self, AGCH):
        self.AGCH = AGCH

def argument_parser():
    parser = OptionParser(option_class=eng_option, usage="%prog: [options]")
    parser.add_option(
        "-f", "--fc", dest="fc", type="eng_float", default=eng_notation.num_to_str(945400000),
        help="Set fc [default=%default]")
    parser.add_option(
        "-g", "--gain", dest="gain", type="eng_float", default=eng_notation.num_to_str(60),
        help="Set gain [default=%default]")
    parser.add_option(
        "-p", "--ppm", dest="ppm", type="intx", default=0,
        help="Set ppm [default=%default]")
    parser.add_option(
        "-s", "--samp-rate", dest="samp_rate", type="eng_float", default=eng_notation.num_to_str(2000000.052982),
        help="Set samp_rate [default=%default]")
    return parser

def main(top_block_cls=gsm_rtl, options=None):
    if options is None:
        options, _ = argument_parser().parse_args()
    
    # execute SQL query using execute() method.
    sql1 = "SELECT * FROM player"
    sql2 = "SELECT * FROM freq_active"

    muter = True
    player = 'n'
    while muter: 
        db = MySQLdb.connect("localhost","root","skm2010","imsi_dump" )
        cursor = db.cursor()
        try:
            cursor.execute(sql2)
            results = cursor.fetchall()
            for row in results:
                freq = row[1]
                tb = top_block_cls(fc=freq, gain=options.gain, ppm=options.ppm, samp_rate=options.samp_rate)
                tb.start()
                time.sleep(5)
                tb.stop()
        except:
            print "Error bro: unable to fecth data"
    db.close()
        
    muter = True
    
if __name__ == '__main__':
    main()
