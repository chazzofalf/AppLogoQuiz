package com.webuildsystems.AppLogoQuiz;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Scores 
{
	public final static class XmlData
	{
		public final static class XmlDataScores
		{
			private ArrayList<XmlDataScores> scores;
			private File fileToLoad;
			private XmlDataScores()
			{
				
			}
			private static boolean testXmlFile(File fileToTest)
			{
				try
				{
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder db = dbf.newDocumentBuilder();
					Document doc = db.parse(fileToTest);
					if (doc.getChildNodes().item(0).getNodeName().equals(XmlInfo.ScoresInfo.NAME))
					{
						NodeList scoreNodes = doc.getChildNodes().item(0).getChildNodes();
						for (int i=0;i<scoreNodes.getLength();i++)
						{
							Node scoreNode = scoreNodes.item(i);
							if (scoreNode.getNodeName().equals(XmlInfo.ScoresInfo.ScoreInfo.NAME))
							{
								XPathFactory xPathFactory = XPathFactory.newInstance();
								XPath xPath = xPathFactory.newXPath();
								Node nameNode = (Node)xPath.evaluate(XmlInfo.ScoresInfo.ScoreInfo.NameInfo.NAME, scoreNode, XPathConstants.NODE);
								Node scoreAmountNode = (Node)xPath.evaluate(XmlInfo.ScoresInfo.ScoreInfo.ScoreElementInfo.NAME, scoreNode,XPathConstants.NODE);
								if (nameNode == null || scoreAmountNode == null)
								{
									return false;
								}
							}
							else
							{
								return false;
							}
						}
						return true;
					}
					else
					{
						return false;
					}
				}
				catch (Exception e)
				{
					return false;
				}
			}
			public static XmlDataScores load(File fileToLoad)
			{
				XmlDataScores newScores = new XmlDataScores();
				if (fileToLoad.exists() && testXmlFile(fileToLoad))
				{
					return null;
				}
				else
				{
					newScores.scores = new ArrayList<Scores.XmlData.XmlDataScores>();
					newScores.fileToLoad = fileToLoad;
					return newScores;
				}
			}
			public void save()
			{
				
			}
			public final static class XmlDataScore
			{
				private String name;
				private String score;
				public String getName()
				{
					return name;
				}
				public String getScore()
				{
					return score;
				}
				private XmlDataScore(String name,String score)
				{
					this.name = name;
					this.score = score;
				}
			}
		}
	}
	public final static class XmlInfo
	{
		public static final String FILENAME = "scores.xml";
		public final static class ScoresInfo
		{
			public static final String NAME = "scores";
			public static final String PATH = "/" + NAME;
			public final static class ScoreInfo
			{
				public static final String NAME = "score";
				public static final String PATH = ScoresInfo.PATH + "/" + NAME;
				public final static class NameInfo
				{
					public static final String NAME = "name";
					public static final String PATH = ScoreInfo.PATH + "/" + NAME;
				}
				public final static class ScoreElementInfo
				{
					public static final String NAME = "score";
					public static final String PATH = ScoreInfo.PATH + "/" + NAME;
				}
			}
		}
	}
}
